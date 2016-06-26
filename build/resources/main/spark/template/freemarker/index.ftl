<#include "/header.ftl">

<body>
<div class="loader"></div>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <!--THIS IS THE SEARCH BAR BOXING-->
        <div class="mdl-grid demo-content">
            <div class="mdl-cell mdl-cell--8-col">
                <div class="full-width-card mdl-card mdl-shadow--2dp">
                    <form action="" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Welcome to URL Short</h2>
                        </div>
                        <div class="mdl-card__supporting-text">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="URL" name="URL">
                                <label class="mdl-textfield__label" for="sample3">URL Here...</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input type="hidden" name="username" id="username" value="${user}">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                                   type="submit" value="MAKE SHORT">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--END OF THE SEARCH BAR BOXING-->
        <div class="mdl-grid demo-content">

        <#list urls as url>
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <img class="image-pefect" src="/media/test/website.png"/>
                    </div>
                    <div class="mdl-card__title mdl-card--expand">
                        <a href="${url.getOriginalURL()}" > <h2 class="mdl-card__title-text">www.acorta.do/${url.getShortURL()}</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                    Directs to: ${url.getOriginalURL()}
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            VIEW STATS
                        </a>
                    </div>
                    <div class="mdl-card__menu">
                        <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                            <i class="material-icons">share</i>
                        </button>
                    </div>
                </div>
            </div>
        <#else>
            <h3>Looks like you have no URL's , try adding one!</h3>
        </#list>







        </div>
    </main>
</div>


</body>