var injectHtml = '<div id="adviser">\
<div id="adviserContent">\
    <img id="adviserImage" src="{host}/resources/images/advisor/advisor.png" /> \
    </div> \
    <div id="advisorButton"> \
    <img id="adviserButtonImage" src="{host}/resources/images/advisorbutton/collapse.png" /> \
    </div> \
    </div> \
    <div id="advisorAdvice" style="display:none"> \
    <img id="advisorAdviceImage" src="{host}/resources/images/text_cloud.png" > \
    <div id="advisorAdviceText"></div> \
</img> \
</div>';

var InnopolisAdviser = {
    jsHostLocation: null,
    cssLocation: "/resources/css/adviser.css",
    jsName: "adviser.js",
    hasAdvice: false,
    adviceShowing: false,
    isHided: false,

    getLocation: function (href) {
        var match = href.match(/^(https?\:)\/\/(([^:\/?#]*)(?:\:([0-9]+))?)([\/]{0,1}[^?#]*)(\?[^#]*|)(#.*|)$/);
        return match && {
                protocol: match[1],
                host: match[2],
                hostname: match[3],
                port: match[4],
                pathname: match[5],
                search: match[6],
                hash: match[7]
            }
    },

    init: function () {
        var that = this;
        $("script").each(function (index, js) {
            if (js.src.indexOf(InnopolisAdviser.jsName) != -1) {
                var location = that.getLocation(js.src);
                if(location == null){
                    that.jsHostLocation = "."; // dev environment
                }
                else{
                    that.jsHostLocation = location.protocol + "//" + location.host;  // production environment
                }
            }
        });

        injectHtml = injectHtml.replace(new RegExp("{host}", 'g'), that.jsHostLocation);


        var script = document.createElement('script');
        script.type = "text/javascript";
        script.async = "async";
        script.defer = "defer";
        script.onload = function () {

            var script2 = document.createElement('script');
            script2.type = "text/javascript";
            script2.async = "async";
            script2.defer = "defer";
            script2.onload = function () {
                that.connect();
            };
            script2.src = "https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js";
            document.getElementsByTagName('head')[0].appendChild(script2);

        };
        script.src = "https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.js";

        document.getElementsByTagName('head')[0].appendChild(script);


        $('head').append('<link rel="stylesheet" type="text/css" href=" ' + InnopolisAdviser.jsHostLocation + InnopolisAdviser.cssLocation + '">');
        $('body').append(injectHtml);

        $("#advisorButton").click(function () {
            if (that.isAdvisorHided()) {
                that.showAdvisor();
            } else {
                that.hideAdvisor();
                that.hideAdvice();
            }
        });

        $("#adviserContent").click(function () {
            if (that.hasAdvice && !that.adviceShowing) {
                that.showAdvice();
            }
        });

        $("#advisorAdvice").click(function () {
            that.hideAdvice();
        });


    },

    setButtonImage : function(image){
        $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/" + image + ".png");
    },

    setAdvisorImage : function(image) {
        $("#adviserImage").attr("src", this.jsHostLocation + "/resources/images/advisor/" + image + ".png"); 
    },

    hideAdvisor: function () {
        //noinspection JSJQueryEfficiency
        $("#adviserContent").animate({"opacity": 0});
        //noinspection JSJQueryEfficiency
        $("#adviserContent").hide();

        if (this.hasAdvice && !this.adviceShowing) {
            this.setButtonImage("blub");
        } else {
            this.setButtonImage("expand");
        }
        this.isHided = true;
    },

    showAdvisor: function () {
        if (this.hasAdvice && !this.adviceShowing) {
            this.setAdvisorImage("advisor_idea");
        } else {
            this.setAdvisorImage("advisor");
        }
        this.setButtonImage("collapse");
        //noinspection JSJQueryEfficiency
        $("#adviserContent").animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#adviserContent").show();
        this.isHided = false;
    },

    isAdvisorHided: function () {
        return this.isHided;
    },

    adviceReceived: function () {
        this.hasAdvice = true;

        if (this.isAdvisorHided()) {
            this.setButtonImage("blub");
        } else {
            this.showAdvisor();
        }
    },

    showAdvice: function () {
        this.adviceShowing = true;
        this.setAdvisorImage("advisor_texting");
        this.setButtonImage("collapse");
        //noinspection JSJQueryEfficiency
        $("#advisorAdvice").animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#advisorAdvice").show();
    },

    hideAdvice: function () {
        this.hasAdvice = false;
        this.adviceShowing = false;
        //noinspection JSJQueryEfficiency
        $("#advisorAdvice").animate({"opacity": 0});
        //noinspection JSJQueryEfficiency
        $("#advisorAdvice").hide();
        this.setAdvisorImage("advisor");
    },

    connect: function () {
        var that = this;
        if(that.jsHostLocation == "."){
            setInterval(function() {
                if(!that.hasAdvice){
                   $('#advisorAdviceText').html("test text");
                   InnopolisAdviser.adviceReceived();
                }
            },5000);
        }
        else{
            var socket = new SockJS(that.jsHostLocation + '/advises');
            this.stompClient = Stomp.over(socket);
            this.stompClient.connect({}, function (frame) {
                console.log('%c' + frame, 'background: #222; color: #bada55');
                that.stompClient.subscribe('/', function (greeting) {
                    //var result = JSON.parse(greeting.body);
                    //console.log(greeting.body);
                    $('#advisorAdviceText').html(greeting.body);
                    InnopolisAdviser.adviceReceived();
                });
            });
        }
    },

};

function Innopolis_Adviser_start() {
    $(function () {
        InnopolisAdviser.init();
    });
}

if (typeof jQuery == 'undefined') {
    var headTag = document.getElementsByTagName("head")[0];
    var jqTag = document.createElement('script');
    jqTag.type = 'text/javascript';
    jqTag.src = 'https://code.jquery.com/jquery-3.1.1.min.js';
    jqTag.onload = function () {
        Innopolis_Adviser_start();
    };
    headTag.appendChild(jqTag);
} else {
    Innopolis_Adviser_start();
}





