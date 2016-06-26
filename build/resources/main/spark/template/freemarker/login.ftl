<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">


        <!--LOGIN BOX-->
        <div class="mdl-grid demo-content">
            <div class="full-centered mdl-cell mdl-cell--6-col" style="width: 95%;">
                <div class="full-width-card mdl-card mdl-shadow--2dp" >
                    <form action="" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Welcome to URL Short</h2>
                        </div>
                        <#if user == "guest">
                        <div class="mdl-card__supporting-text">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="username" name="username">
                                <label class="mdl-textfield__label" >Username</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="password" id="password" name="password">
                                <label class="mdl-textfield__label">password.</label>
                            </div>

                            <div class="g-recaptcha" data-sitekey="6Le7WCMTAAAAAFGqChVDfyU4lrF2N-ETD54H4WQa"></div>

                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Login">
                        </div>
                        <#else>
                            <div class="mdl-card__supporting-text">
                                <p>You are alreafy logged in, no need to log in again.</p>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="/logout">Log OUT</a>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="/">Return to HOME</a>
                            </div>
                        </#if>
                    </form>
                </div>
            </div>
        </div>
        <!--END LOGIN BOX-->


    </main>
</div>


</body>