<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <style>
            .demo-card-wide.mdl-card {
                width: 410px;
                max-width: 100%;
                margin: 10px;
            }

            .demo-card-wide > .mdl-card__title {
                color: #fff;

                background: red; /* For browsers that do not support gradients */
                background: -webkit-linear-gradient(brown, darkred); /* For Safari 5.1 to 6.0 */
                background: -o-linear-gradient(brown, darkred); /* For Opera 11.1 to 12.0 */
                background: -moz-linear-gradient(brown, darkred); /* For Firefox 3.6 to 15 */
                background: linear-gradient(brown, darkred); /* Standard syntax */
            }

            .demo-card-wide > .mdl-card__menu {
                color: #fff;
            }
        </style>
        <div class="mdl-grid demo-content">

            <div class="mdl-cell mdl-cell--12-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="max-width: 100%; margin: 10px; min-width: 88%">
                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Set post ID for testing</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <form action="#">
                            <div class="mdl-textfield mdl-js-textfield">
                                <input class="mdl-textfield__input" type="text" id="post_id">
                                <label class="mdl-textfield__label" for="post_id">Post ID...</label>
                            </div>
                        </form>
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" onclick="setValues()">
                            Config examples
                        </a>
                    </div>
                </div>
            </div>

            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <h2  class="mdl-card__title-text">Show all urls on the database</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get all the url's of the system, you can access via this url: XXXXXXXXXXX
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="first" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" >
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">

                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Get the original url form the ID</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get the originial url from the ID, you can access via this url: XXXXXX
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="second" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" >
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">

                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Get Short URL</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get a short URL, based on its ID , you can get it via this url:
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="third"class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">

                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Show a user urls</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get all the url's of a user, you can access via this url:
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="fourth" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">

                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Show a user urls</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get all the url's of a user, you can access via this url:
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="fifth"class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" >
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <div class="to_hide demo-card-wide mdl-card mdl-shadow--2dp">

                    <div class="mdl-card__title mdl-card--expand">
                        <a href="#"><h2 class="mdl-card__title-text">Show a user urls</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        To get all the url's of a user, you can access via this url:
                        Also, you can click on the button below to access the JSON example for your current user
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a id="sixth" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            VIEW JSON EXAMPLE
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $('.to_hide').hide();
            var first = $("#first");
            var second =$("#second")
            var third = $("#third")
            var fourth = $("#fourth");
            var fifth = $("#fifth");
            var sixth = $("#sixth");

            function setValues() {
                $('.to_hide').show( "slow" );
                var theId= $('#post_id').val();
                console.log("ENTRAMO " +theId)
                first.attr("href", "/json/allurls");
                second.attr("href", "/json/original/"+theId);
                third.attr("href", "/json/url/"+theId);
                fourth.attr("href", "/json/allusers");
                fifth.attr("href", "/json/user/admin");
                sixth.attr("href", "/json/admin/urls");
            }

        </script>


    </main>
</div>


</body>