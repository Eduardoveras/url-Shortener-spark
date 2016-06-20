<#include "/header.ftl">

<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <!--THIS IS THE SEARCH BAR BOXING-->
        <div class="mdl-grid demo-content">
            <div class="mdl-cell mdl-cell--8-col">
                <div class="full-width-card mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Welcome to URL Short</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <form action="#">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="sample3" required/>
                                <label class="mdl-textfield__label" for="sample3">URL Here...</label>
                            </div>
                        </form>
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                            MAKE SHORT
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!--END OF THE SEARCH BAR BOXING-->
        <div class="mdl-grid demo-content">

            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <img class="image-pefect" src="/media/test/website.png" />
                    </div>
                    <div class="mdl-card__title mdl-card--expand">
                        <h2 class="mdl-card__title-text">SHORT URL</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Mauris sagittis pellentesque lacus eleifend lacinia...
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

            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <img class="image-pefect" src="/media/test/website.png" />
                    </div>
                    <div class="mdl-card__title mdl-card--expand">
                        <h2 class="mdl-card__title-text">SHORT URL</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Mauris sagittis pellentesque lacus eleifend lacinia...
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
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title mdl-card--expand">
                        <img class="image-pefect" src="/media/test/website.png" />
                    </div>
                    <div class="mdl-card__title mdl-card--expand">
                        <h2 class="mdl-card__title-text">SHORT URL</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Mauris sagittis pellentesque lacus eleifend lacinia...
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


        </div>
    </main>
</div>


</body>