<#include "/header.ftl">

<body>
<div class="loader"></div>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <div class="mdl-grid demo-content">

        <#list urls as url>
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <img class="image-pefect" src="${url.getPreviewURL()}"/>
                    </div>
                    <div class="mdl-card__title mdl-card--expand">
                        <a href="/p/${url.getShortURL()}" > <h2 class="mdl-card__title-text">www.acorta.do/${url.getShortURL()}</h2></a>
                    </div>
                    <div class="mdl-card__supporting-text">
                        Directs to: ${url.getOriginalURL()}
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/p/${url.getShortURL()}/stats">
                            VIEW STATS
                        </a>
                        <form action="" METHOD="POST">
                                <input type="hidden" name="url" id="url" value="${url.getShortURL()}">
                                <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" value="DELETE">
                        </form>
                    </div>
                    <div class="mdl-card__menu">
                        <a href="javascript:fbShare('www.acorta.do/${url.getShortURL()}', 'Fb Share', 'Facebook share popup', 'https://www.colourbox.com/preview/2375712-vector-icon-of-scissors-all-layers-are-grouped.jpg', 520, 350)" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                            <i class="material-icons">share</i>
                        </a>


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