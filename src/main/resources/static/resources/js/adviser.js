var injectHtml = '<div id="advisor">\
        <div id="advisorContent">\
            <img id="advisorImage" class="image" src="advisor.png"/>\
        </div>\
        <div id="advisorButtons">\
            <div id="settingsButton" class="button50" >\
                <img id="settingsButtonImage" class="image50">\
            </div>\
            <div id="adviceRequestButton" class="button50" >\
                <img id="adviceRequestButtonImage" class="image50">\
            </div>\
        </div>\
        <div id="advisorButton" class="button50">\
            <img id="advisorButtonImage" class="image50">\
        </div>\
        <div id="advisorAdvice">\
            <div id="leftButton" class="button">\
                <img id="leftButtonImage" class="image">\
            </div>\
            <div id="adviceContent" class="content">\
                \
            </div>\
            <div id="rightButton" class="button">\
                <img id="rightButtonImage" class="image">\
            </div>\
            <div id="adviceCloseButton" class="button50">\
                <img id="closeAdviceButtonImage" class="image50">\
            </div>\
        </div>\
        <div id="myModal" class="modal">\
            <div class="modal-content">\
                <span class="close">&times;</span>\
                <p>Выберите представление помошника</p>\
                <select id="skinSelector">\
                      <option value="default">Стандартный</option>\
                      <option value="minion">Минионы</option>\
                </select>\
                <button id="modalDialogOkButton">Ok</button>\
            </div>\
        </div>\
    </div>';

var InnopolisAdviser = {
    jsHostLocation: null,
    advicePool : ["Привет! Я ваш помошник, время от времени я буду давать полезные советы."],
    currentAdviceIndex : 0,
    cssLocation: "resources/css/adviser.css",
    jsName: "adviser.js",
    selectedAdvisor : "default",
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
        var self = this;
        $("script").each(function (index, js) {
            if (js.src.indexOf(self.jsName) != -1) {
                var location = self.getLocation(js.src);
                    self.jsHostLocation = location.protocol + "//" + location.host;
            }
        });
        
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
                self.connect();
            };
            script2.src = "https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js";
            document.getElementsByTagName('head')[0].appendChild(script2);

        };
        script.src = "https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.js";

        document.getElementsByTagName('head')[0].appendChild(script);

        $('head').append('<link rel="stylesheet" type="text/css" href=" ' + this.jsHostLocation + this.cssLocation + '">');
        $('body').append(injectHtml);

        //bind ui
        this.bindButtons(this);
        this.bindSettingsModal(this);

        //initial state
        this.hideAdvice();
        this.hideAdvisor();
        this.setImage("settingsButtonImage","settings"); //todo set specific method
        this.setImage("adviceRequestButtonImage","show_advice");//todo set specific method
    },

    bindButtons : function (self) {
        //show-hide advisor button
        $("#advisorButton").click(function () {
            if (self.isAdvisorHided()) {
                self.showAdvisor();
            } else {
                self.hideAdvisor();
                self.hideAdvice();
            }
        });

        //left and right advice cloud buttons
        $("#leftButton").click(function () {
            self.adviceLeftButtonClicked();
        });
        $("#rightButton").click(function () {
            self.adviceRightButtonClicked();
        });

        //advice request button
        $("#adviceRequestButton").click(function () {
            if (self.hasAdvice && !self.adviceShowing) {
                self.showAdvice();
            }
        });

        //button self closes advice cloud
        $("#adviceCloseButton").click(function () {
            self.hideAdvice();
        });
    },

    bindSettingsModal : function (self) {
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("settingsButton");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // Handle ok button
        var okButton = document.getElementById("modalDialogOkButton");
        okButton.onclick = function () {
            modal.style.display = "none";
            self.selectedAdvisor = document.getElementById("skinSelector").value;
            self.hideAdvice();
            self.hideAdvisor();      
        }

        // When the user clicks on the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    },

    adviceLeftButtonClicked : function () {
        if(this.advicePool.length == 0){
            return;
        }
        if(this.currentAdviceIndex == 0){
            this.loadAdvice(this.advicePool.length - 1);
        }
        else{
            this.loadAdvice(this.currentAdviceIndex - 1);
        }
    },

    adviceRightButtonClicked : function () {
        if(this.advicePool.length == 0){
            return;
        }
        if(this.currentAdviceIndex == this.advicePool.length - 1){
            this.loadAdvice(0);
        }
        else{
            this.loadAdvice(this.currentAdviceIndex + 1);
        }
    },

    loadAdvice : function(index) {
        var adviceToLoad = this.advicePool[index];
        document.getElementById("adviceContent").innerHTML = adviceToLoad;
        this.currentAdviceIndex = index;
    },

    setButtonImage : function(image){
        $("#advisorButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor
        + "/" + image + ".png");
    },

    setAdvisorImage : function(image) {
        $("#advisorImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
        + image + ".png");
    },

    setImage : function(image,src) {
        $("#" + image).attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
            + src + ".png");
    },

    showDiv : function(div){
        //noinspection JSJQueryEfficiency
        $("#" + div).animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#" + div).show();
    },

    hideDiv : function(div){
        //noinspection JSJQueryEfficiency
        $("#" + div).animate({"opacity": 0});
        //noinspection JSJQueryEfficiency
        $("#" + div).hide();
    },

    hideAdvisor: function () {
        this.hideDiv("advisorContent");
        this.hideDiv("adviceRequestButton");
        this.hideDiv("settingsButton");

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
        this.showDiv("advisorContent");
        this.showDiv("adviceRequestButton");
        this.showDiv("settingsButton");
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
            this.loadAdvice(this.advicePool.length - 1);
            this.showAdvisor();
        }
    },

    showAdvice: function () {
        this.adviceShowing = true;
        this.setAdvisorImage("advisor_texting");
        this.setButtonImage("collapse");
        this.showDiv("advisorAdvice");
    },

    hideAdvice: function () {
        this.hasAdvice = false;
        this.adviceShowing = false;
        this.hideDiv("advisorAdvice");
        this.setAdvisorImage("advisor");
    },

    connect: function () {
        var self = this;
            var socket = new SockJS(self.jsHostLocation + '/advises');
            this.stompClient = Stomp.over(socket);
            this.stompClient.connect({}, function (frame) {
                console.log('%c' + frame, 'background: #222; color: #bada55');
                self.stompClient.subscribe('/', function (greeting) {
                    //var result = JSON.parse(greeting.body);
                    //console.log(greeting.body);
                    $('#advisorAdviceText').html(greeting.body);
                    InnopolisAdviser.adviceReceived();
                });
            });
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





