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
                that.jsHostLocation = location.protocol + "//" + location.host;
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
    hideAdvisor: function () {
        //noinspection JSJQueryEfficiency
        $("#adviserContent").animate({"opacity": 0});
        //noinspection JSJQueryEfficiency
        $("#adviserContent").hide();

        if (this.hasAdvice && !this.adviceShowing) {
            $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/blub.png");
        } else {
            $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/expand.png");
        }
    },

    showAdvisor: function () {
        if (this.hasAdvice && !this.adviceShowing) {
            $("#adviserImage").attr("src", this.jsHostLocation + "/resources/images/advisor/advisor_idea.png");
        } else {
            $("#adviserImage").attr("src", this.jsHostLocation + "/resources/images/advisor/advisor.png");
        }
        $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/collapse.png");
        //noinspection JSJQueryEfficiency
        $("#adviserContent").animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#adviserContent").show();
    },

    isAdvisorHided: function () {
        return $("#adviserContent").css('opacity') == 0;
    },

    adviceReceived: function () {
        this.hasAdvice = true;

        if (this.isAdvisorHided()) {
            $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/blub.png");
        } else {
            this.showAdvisor();
        }
    },

    showAdvice: function () {
        this.adviceShowing = true;
        $("#adviserImage").attr("src", this.jsHostLocation + "/resources/images/advisor/advisor_texting.png");
        $("#adviserButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisorbutton/collapse.png");
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

        $("#adviserImage").attr("src", this.jsHostLocation + "/resources/images/advisor/advisor.png");
    },

    connect: function () {
        var that = this;
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


};

$(function () {
    InnopolisAdviser.init();
});



