var InnopolisAdviser = {
    jsHostLocation: null,
    advicePool: [],
    currentAdviceIndex: 0,
    jsName: "adviser.js",
    selectedAdvisor: "default",
    hasAdvice: false,
    adviceShowing: false,
    isHided: false,

    // Method that checks if hardware running advisor is mobile or not
    // returns true if it is mobile, other way false
    checkIfMobile : function() {
    if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent)
        || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) {
            return true
        };
        return false;
    },

    // Advisor initialization function. Advisor main entry point.
    init: function () {

        //Check if it is mobile and correct paths for this
        var mobile = "";
        if(this.checkIfMobile()){
            mobile = "mobile";
        }

        //initial advisor selected
        if(this.getCookie("selectedAdvisor")==""){
            this.setCookie("selectedAdvisor","default",365);
            this.selectedAdvisor = "default";
        }
        else {
            this.selectedAdvisor = this.getCookie("selectedAdvisor");
        }

// add css and html advisor template to current view
        $('head').append('<link rel="stylesheet" type="text/css" href=" ' + this.jsHostLocation
                           + "/resources/css/adviser" + mobile + '.css">');
        $.ajax({
            url: this.jsHostLocation + "/templates/adviser" + mobile + ".html",
            async: false
        }).done(function (content) {
            $('body').append(content);
        });

        //bind ui buttons
        this.bindButtons(this);
        this.bindSettingsModal(this);
        this.bindSkinSelector(this);
        //setting initial state
        this.setInitialState();
        // connecting to our server
        this.connect();

        //initial advice check //todo to a method
        if(this.getCookie("greeting")==""){
            var advice = {
                        id : 1,
                        content : "<p>Привет! Я ваш помощник, время от времени я буду давать полезные советы.</p>"
                    };
            this.adviceReceived(advice);
            this.showAdvice();

            this.setCookie("greeting","was",30);
        }
    },

    // Method that sets advisor to initial state
    setInitialState : function(){
            this.hideAdvice();
            this.showAdvisor();
            this.setAdvisorImage("advisor");
            this.setImage("settingsButtonImage", "settings");
            this.setImage("adviceRequestButtonImage", "show_advice");
            this.setImage("closeAdviceButtonImage", "close");
            this.setImage("rightButtonImage", "next_advice");
            this.setImage("leftButtonImage", "prev_advice");
    },

    //Generic set cookie method
    //  cname   - cookie key
    //  cvalue  - cookie value
    //  exdays  - cookie expiration period
    setCookie : function (cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires="+ d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    },

    //generic get cookie method
    //  cname   - cookie key
    //  returs string of value that connected to given key, or returns empty string if not found
    getCookie : function (cname){
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    },

    // Binding ui buttons
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

    //Binding settings window
    bindSettingsModal: function (self) {
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("settingsButton");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks on the button, open the modal
        btn.onclick = function () {
            modal.style.display = "block";
            $("#"+ self.selectedAdvisor +"SkinSelector").css("border-width","5px");
        };

        document.getElementById("closeSettingsButton").onclick = function () {
            self.setInitialState();
            modal.style.display = "none";
        };

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            self.setInitialState();
            modal.style.display = "none";
        };

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                self.setInitialState();
                modal.style.display = "none";
            }
        }
    },

    //left, previous advice clicked handler
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

    //right, next advice clicked handler
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

    //loads advice from advice pool to view
    //  index   - advice index to load
    loadAdvice: function (index) {
        var adviceContent = this.advicePool[index].content;
        var advicePlaceHolder = document.getElementById("adviceContent");
        advicePlaceHolder.innerHTML = adviceContent;
        this.currentAdviceIndex = index;
    },

    //sets image for main advisor show-hide button
    //  image   - image src key
    setButtonImage: function (image) {
        $("#advisorButtonImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor
            + "/" + image + ".png");
    },

    //sets image for main advisor picture
    //  image   - image src key
    setAdvisorImage: function (image) {
        $("#advisorImage").attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
            + image + ".png");
    },

    //sets image for a given img tag
    //  image   - img tag id
    //  src     - image src key
    setImage: function (image, src) {
        $("#" + image).attr("src", this.jsHostLocation + "/resources/images/advisors/" + this.selectedAdvisor + "/"
            + src + ".png");
    },

    //method that shows div
    //  div - div id key
    showDiv: function (div) {
        //noinspection JSJQueryEfficiency
        $("#" + div).animate({"opacity": 1});
        //noinspection JSJQueryEfficiency
        $("#" + div).show();
    },

    //method that hides div
    //  div - div id key
    hideDiv: function (div) {
        //noinspection JSJQueryEfficiency
        $("#" + div).animate({"opacity": 0});
        //noinspection JSJQueryEfficiency
        $("#" + div).hide();
    },

    //method that transfers advisor into hided state
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

    //method that transfers advisor into showed state
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

    //OBSOLETE TODO replace call for this.isHided
    //method that returns if the advisor is hided or not
    // returns true if advisor state is hided, other way returns false.
    isAdvisorHided: function () {
        return this.isHided;
    },

    //method checks if given id is contains in advice pool
    //returns true if it is
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

    //advice received handler
    //  advice  - advice in JSON representation
    adviceReceived: function (advice) {
        if(this.checkId(advice.id)){
            return;
        }

        this.advicePool.push(advice);

        this.hasAdvice = true;

        if (this.isAdvisorHided()) {
            this.setButtonImage("blub");
        } else {
            this.showAdvisor();
        }
        this.setImage("adviceRequestButtonImage", "blub");
        this.loadAdvice(this.advicePool.length - 1);
    },

    //method that transfers advisor into showing advice state
    showAdvice: function () {
        this.adviceShowing = true;
        this.setAdvisorImage("advisor_texting");
        this.setImage("adviceRequestButtonImage", "show_advice");
        this.setButtonImage("collapse");
        this.showDiv("advisorAdvice");
    },

    //method that hides the advice and transfers the advisor into showed state
    hideAdvice: function () {
        this.hasAdvice = false;
        this.adviceShowing = false;
        this.hideDiv("advisorAdvice");
        this.setAdvisorImage("advisor");
    },

    // connecting to server and subscribing to web sockets
    connect: function () {
        var self = this;
        var socket = new SockJS(self.jsHostLocation + '/advises');
        this.stompClient = Stomp.over(socket);
        this.stompClient.connect({}, function (frame) {
            self.stompClient.subscribe('/partnerAdvertisement', function (message) {
                var advice = JSON.parse(message.body);
                advice.content = advice.content.replace(/&#34/g,'"')
                InnopolisAdviser.adviceReceived(advice);
            });
        });
    },

    /*skin selector methods*/
    //binding handlers for settings and skin selection popup
    bindSkinSelector : function (self){
        $("#defaultSkinSelector").click(function () {
            self.selectSkin("default");
                });
        $("#minionSkinSelector").click(function () {
            self.selectSkin("minion");
                });
        $("#alexSkinSelector").click(function () {
            self.selectSkin("alex");
                });
        $("#pandaSkinSelector").click(function () {
            self.selectSkin("panda");
                });
    },

    //selects the skin
    //  skin    - skin key
    selectSkin : function (skin){
        $("#skinSelector").find("img").css("border-width","0px");
        $("#"+skin+"SkinSelector").css("border-width","5px");
        this.setCookie("selectedAdvisor",skin,365);
        this.selectedAdvisor = skin;
    }

};