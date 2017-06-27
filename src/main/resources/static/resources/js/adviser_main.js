var InnopolisAdviser = {
        jsHostLocation: null,
        jsName: "adviser.js",
        selectedAdvisor: "minion",
        hasAdvice: false,
        adviceShowing: false,
        isHided: false,
        adviceType: "",
        adviceLink: "",
        upClass: "toggle-up",
        downClass: "toggle-down",
        changeOpen: false,
        DELAY: 300,
        clicks: 0,
        timer: null,
        skins: ['minion', 'panda', 'raccoon', 'kitty'],
        dblClick: false,

// Method that checks if hardware running advisor is mobile or not
// returns true if it is mobile, other way false
        checkIfMobile: function () {
            return !!(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent)
            || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0, 4)));
        }
        ,

// Advisor initialization function. Advisor main entry point.
        init: function () {

            //Check if it is mobile and correct paths for this
            // change only fonts in case of mobile
            var mobile = "";
            if (this.checkIfMobile()) {
                mobile = "mobile";
            }

            //initial advisor selected
            if (this.getCookie("selectedAdvisor") == "") {
                this.setCookie("selectedAdvisor", "minion", 365);
                this.selectedAdvisor = "minion";
            }
            else {
                this.selectedAdvisor = this.getCookie("selectedAdvisor");
            }

            // add css and html advisor template to current view
            $('head').append('<link rel="stylesheet" type="text/css" href=" ' + this.jsHostLocation
                + "/resources/css/adviser" + '.css"/><link rel="stylesheet" type="text/css" href=" ' + this.jsHostLocation
                + "/resources/css/font" + mobile + '.css"/>');
            $.ajax({
                url: this.jsHostLocation + "/templates/adviser" + ".html",
                async: false
            }).done(function (content) {
                $('body').append(content);
            });

            //setting initial state
            this.setInitialState();
            // connecting to our server
            this.connect();

            //initial advice check
            this.checkInitAdvice();

            //$('.ui-loader').remove();
        }
        ,

// checks whether greeting advice was already shown to user
        checkInitAdvice: function () {
            if (this.getCookie("greeting") == "") {
                var advice = {
                    id: 1,
                    content: "<p>Привет! Я ваш помощник, время от времени я буду давать полезные советы.</p>"
                };
                this.adviceReceived(advice);
                this.showAdvice();
                this.setCookie("greeting", "was", 30);
            }
        }
        ,

// Method that sets advisor to initial state
        setInitialState: function () {
            this.hideAdvice();
            this.hideAdvisor();
            this.separateClicks(this);
            this.onTapHold(this);
            this.clickOutside("advisorChange", this);
        }
        ,

        // loads skins for list of advisors for change
        advisorSkinsLoad: function (self) {
            for (var i = 0; i < self.skins.length; i++) {
                if (self.skins[i] != this.selectedAdvisor)
                    self.setImage(self.skins[i], self.skins[i] + "/advisor");
            }
        }
        ,

//Generic set cookie method
//  cname   - cookie key
//  cvalue  - cookie value
//  exdays  - cookie expiration period
        setCookie: function (cname, cvalue, exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
            var expires = "expires=" + d.toUTCString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
        }
        ,

//Method that detects click outside the element
// for advisor selection it hides advisor selection field
//  elementId   - element outside which click is analyzed
        clickOutside: function (elementId, self) {
            $(document).click(function (e) {
                // check that your clicked
                // element has no id=info
                // and is not child of info
                console.log(e.target.id);
                if (e.target.id != elementId && !$('#info').find(e.target).length) {
                    if (self.changeOpen) {
                        $("#" + elementId).hide();
                        self.changeOpen = false;
                        $("#skinSelector").empty();
                    }
                }
            });
        }
        ,


//generic get cookie method
//  cname   - cookie key
//  returs string of value that connected to given key, or returns empty string if not found
        getCookie: function (cname) {
            var name = cname + "=";
            var decodedCookie = decodeURIComponent(document.cookie);
            var ca = decodedCookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
        ,


// Click event on advisor
        advisorClick: function (self) {
            // show advice
            if (self.hasAdvice && !self.adviceShowing) {
                self.toggle("advisorImage");
                setTimeout(function () {
                    self.setAdvisorImage("advice/" + this.adviceType);
                    self.showAdvice();
                }, 600);
            }
            else if (self.adviceShowing) {
                if (self.adviceType == 2 || self.adviceType == 3) {
                    var win = window.open(self.adviceLink, '_blank');
                    if (win) {
                        //Browser has allowed it to be opened
                        win.focus();
                    } else {
                        //Browser has blocked it
                        alert('Please allow popups for this website');
                    }
                }
                self.hideAdvice();
                self.hideAdvisor();
                self.setAdvisorImage(self.selectedAdvisor + "/advisor");
            }
        }
        ,

        showAdvisorChoice: function (self) {
            // $('.ui-loader').remove();
            if (!self.changeOpen) {
                self.showDiv("advisorChange");
                self.changeOpen = true;
                $(".skinContainer").click(function (e) {
                    self.selectSkin(e.target.id);
                });
            }
            else {
                self.changeOpen = false;
                $("#skinSelector").empty();
            }
        }
        ,

// function which separates
// double click from single click
        separateClicks: function (self) {
            $("#advisorContent").click(function (e) {
                self.clicks++;  //count clicks
                if (self.clicks === 1) {
                    self.timer = setTimeout(function () {
                        self.dblClick = false;
                        self.advisorClick(self);
                        $("#advisorChange").hide();
                        self.changeOpen = false;
                        clearTimeout(self.timer);
                        self.clicks = 0;             //after action performed, reset counter
                    }, self.DELAY);
                } else {
                    self.dblClick = true;
                    clearTimeout(self.timer);    //prevent single-click action
                    clearTimeout(self.timer - self.clicks);    //prevent single-click action
                    self.advisorSkinsLoad(self);
                    self.showAdvisorChoice(self);
                    self.clicks = 0;             //after action performed, reset counter
                }
                e.stopPropagation();
            });
        }
        ,

        onTapHold: function (self) {
            $("#advisorImage").bind("taphold", tapholdHandler);
            function tapholdHandler(event) {
                self.advisorSkinsLoad(self);
                self.showAdvisorChoice(self);
            }
        }
        ,

//sets image for main advisor picture
//  image   - image src key
        setAdvisorImage: function (image) {
            $("#advisorImage").attr("src", this.jsHostLocation + "/resources/images/advisor_material/" + image + ".png");
        }
        ,

//sets image for a given img tag
//  image   - img tag id
//  src     - image src key
        setImage: function (image, src) {
            $("#skinSelector").append("<img id='" + image + "' class='skinContainer' />");
            $("#" + image).attr("src", this.jsHostLocation + "/resources/images/advisor_material/" + src + ".png");
        }
        ,

//method that shows div
//  div - div id key
        showDiv: function (div) {
            //noinspection JSJQueryEfficiency
            $("#" + div).animate({"opacity": 1});
            //noinspection JSJQueryEfficiency
            $("#" + div).show();
        }
        ,

//method that hides div
//  div - div id key
        hideDiv: function (div) {
            //noinspection JSJQueryEfficiency
            $("#" + div).animate({"opacity": 0});
            //noinspection JSJQueryEfficiency
            $("#" + div).hide();
        }
        ,

//method that transfers advisor into hided state
        hideAdvisor: function () {
            this.hideDiv("advisorContent");
            this.isHided = true;
        }
        ,

//method that transfers advisor into showed state
        showAdvisor: function () {
            if (this.hasAdvice) {
                this.showDiv("advisorContent");
                // this.showAdvice();
            } else {
                this.hideAdvisor();
            }
            this.isHided = false;
        }
        ,

// function that rotates the advisor
        toggle: function (imageDiv) {
            var square = document.querySelector("#" + imageDiv);
            if (~square.className.indexOf(this.downClass)) {
                square.className = square.className.replace(this.downClass, this.upClass);
            } else {
                square.className = square.className.replace(this.upClass, this.downClass);
            }
        }
        ,

//OBSOLETE TODO replace call for this.isHided
//method that returns if the advisor is hided or not
// returns true if advisor state is hided, other way returns false.
        isAdvisorHided: function () {
            return this.isHided;
        }
        ,

//advice received handler
//  advice  - advice in JSON representation
        adviceReceived: function (advice) {
            this.hasAdvice = true;
            this.loadAdvice(advice);
        }
        ,

//method that transfers advisor into showing advice state
        showAdvice: function () {
            this.adviceShowing = true;
            // change image
            if (this.adviceType != null) {
                this.setAdvisorImage("advice/" + this.adviceType);
            }
            else {
                this.setAdvisorImage(this.selectedAdvisor + "/advisor");
            }
            this.showDiv("advisorAdvice");
        }
        ,

//method that hides the advice and transfers the advisor into showed state
        hideAdvice: function () {
            this.hasAdvice = false;
            this.adviceShowing = false;
            this.hideDiv("advisorAdvice");
            this.setAdvisorImage(this.selectedAdvisor + "/advisor");
        }
        ,

//loads advice from advice pool to view
//  index   - advice index to load
        loadAdvice: function (advice) {
            this.adviceType = advice.type;
            this.adviceLink = advice.link;
            var adviceContent = advice.content;
            var advicePlaceHolder = document.getElementById("adviceContent");
            advicePlaceHolder.innerHTML = adviceContent;
            this.showAdvisor();
        }
        ,

// connecting to server and subscribing to web sockets
        connect: function () {
            var self = this;
            var socket = new SockJS(self.jsHostLocation + '/advises');
            this.stompClient = Stomp.over(socket);
            this.stompClient.connect({}, function (frame) {
                self.stompClient.subscribe('/partnerAdvertisement', function (message) {
                    var advice = JSON.parse(message.body);
                    advice.content = advice.content.replace(/&#34/g, '"')
                    InnopolisAdviser.adviceReceived(advice);
                });
            });
        }
        ,

//selects the skin
//  skin    - skin key
        selectSkin: function (skin) {
            this.hideDiv("advisorChange");
            $("#skinSelector").empty();
            $("#" + skin).id = "#" + this.selectedAdvisor;
            this.setCookie("selectedAdvisor", skin, 365);
            this.selectedAdvisor = skin;
            this.setAdvisorImage(skin + "/advisor");
        }

    }
    ;
