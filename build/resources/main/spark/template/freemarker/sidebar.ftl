<div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
    <header class="demo-drawer-header">
        <img src="https://getmdl.io/templates/dashboard/images/user.jpg" class="demo-avatar">
        <div class="demo-avatar-dropdown">
            <span>${user.getUsername()}@example.com</span>
            <div class="mdl-layout-spacer"></div>
            <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                <i class="material-icons" role="presentation">arrow_drop_down</i>
                <span class="visuallyhidden">Accounts</span>
            </button>
            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                <li class="mdl-menu__item">${user.getUsername()}@example.com</li>
                <li class="mdl-menu__item">info@example.com</li>
                <li class="mdl-menu__item"><i class="material-icons">add</i>Add another account...</li>
            </ul>
        </div>
    </header>
    <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
    <#if user.isAdmin()>
        <a class="mdl-navigation__link" href="/"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                    role="presentation">home</i>Home</a>
        <a class="mdl-navigation__link" href="/login"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                         role="presentation">people</i>Login</a>
        <a class="mdl-navigation__link" href="/register"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                            role="presentation">person_add</i>Register</a>
        <a class="mdl-navigation__link" href="/users"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                         role="presentation">assignment_ind</i>Manage Users</a>
        <a class="mdl-navigation__link" href="/instructions"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                role="presentation">assignment</i>Instructions</a>
        <a class="mdl-navigation__link" href="/viewall"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                           role="presentation">list</i>ViewAll</a>
        <a class="mdl-navigation__link" href="/map"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                       role="presentation">map</i>View Map</a>
        <a class="mdl-navigation__link" href="/dev"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                       role="presentation">developer_board</i>Developer Guidep</a>
    <#else>
        <a class="mdl-navigation__link" href="/"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                    role="presentation">home</i>Home</a>
        <a class="mdl-navigation__link" href="/login"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                         role="presentation">people</i>Login</a>
        <a class="mdl-navigation__link" href="/register"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                            role="presentation">person_add</i>Register</a>
        <a class="mdl-navigation__link" href="/instructions"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                role="presentation">assignment</i>Instructions</a>
        <a class="mdl-navigation__link" href="/map"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                                role="presentation">map</i>View Map</a>
        <a class="mdl-navigation__link" href="/dev"><i class="mdl-color-text--blue-grey-400 material-icons"
                                                       role="presentation">developer_board</i>Developer Guide</a>

    </#if>
        <div class="mdl-layout-spacer"></div>
        <a class="mdl-navigation__link" href="https://github.com/Eduardoveras94/url-Shortener-spark"><i
                class="mdl-color-text--blue-grey-400 material-icons" role="presentation">timeline</i>GitHub<span
                class="visuallyhidden">Help</span></a>
    </nav>
</div>