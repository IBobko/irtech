var InnopolisAdviser = {
    jsHostLocation: null,
    advicePool: [],
    currentAdviceIndex: 0,
    cssLocation: "/resources/css/adviser.css",
    jsName: "adviser.js",
    selectedAdvisor: "default",
    hasAdvice: false,
    adviceShowing: false,
    isHided: false,

    init: function () {
        $('head').append('<link rel="stylesheet" type="text/css" href=" ' + this.jsHostLocation + this.cssLocation + '">');
        $.ajax({
            url: this.jsHostLocation + "/templates/adviser.html",
            async: false
        }).done(function (content) {
            $('body').append(content);
        });

        //bind ui
        this.bindButtons(this);
        this.bindSettingsModal(this);

        //initial state
        this.hideAdvice();
        this.hideAdvisor();
        this.setImage("settingsButtonImage", "settings");
        this.setImage("adviceRequestButtonImage", "show_advice");
        this.setImage("closeAdviceButtonImage", "close");
        this.setImage("rightButtonImage", "next_advice");
        this.setImage("leftButtonImage", "prev_advice");
        this.connect();
    },

    bindButtons: function (self) {
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

    bindSettingsModal: function (self) {
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
        };

        // When the user clicks on the button, open the modal 
        btn.onclick = function () {
            modal.style.display = "block";
        };

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        };

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    },

    adviceLeftButtonClicked: function () {
        if (this.advicePool.length == 0) {
            return;
        }
        if (this.currentAdviceIndex == 0) {
            this.loadAdvice(this.advicePool.length - 1);
        }
        else {
            this.loadAdvice(this.currentAdviceIndex - 1);
        }
    },

    adviceRightButtonClicked: function () {
        if (this.advicePool.length == 0) {
            return;
        }
        if (this.currentAdviceIndex == this.advicePool.length - 1) {
            this.loadAdvice(0);
        }
        else {
            this.loadAdvice(this.currentAdviceIndex + 1);
        }
    },

    loadAdvice: function (index) {
        if (!this.hasAdvice) {
            document.getElementById("adviceContent").html = this.advicePool[index].content;
            this.currentAdviceIndex = index;
        }
    },

    setButtonImage: function (image) {
        $("#advisorButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor
            + "/" + image + ".png");
    },

    setAdvisorImage: function (image) {
        $("#advisorImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
            + image + ".png");
    },

    setImage: function (image, src) {
        $("#" + image).attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
            + src + ".png");
    },

    showDiv: function (div) {
        //noinspection JSJQueryEfficiency
        $("#" + div).animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#" + div).show();
    },

    hideDiv: function (div) {
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

    checkId : function(id){
        var self = this;
        if(self.advicePool.length == 0){
            return false;
        }
        for(var i = 0; i < self.advicePool.length; i++) {
            if (self.advicePool[i].id == id) {
                return true;
            }
        }
        return false;
    },

    adviceReceived: function (advice) {
        if(this.checkId(advice.id)){
            return;
        }

        this.advicePool.push(advice);

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
            self.stompClient.subscribe('/', function (greeting) {
                //var result = JSON.parse(greeting.body);
                //console.log(greeting.body);
                var advice = {
                    id : "1",
                    type : "Text",
                    content : "Привет! Я ваш помошник, время от времени я буду давать полезные советы."
                };
                InnopolisAdviser.adviceReceived(advice);
            });
        });
    }
};
