<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">

    <main style="height: 100%;" class="mdl-layout__content mdl-color--grey-100">
        <div style="height: 100%; overflow-x: auto">
            <table class="custom-table mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">Picture</th>
                    <th class="mdl-data-table__cell--non-numeric">Username</th>
                    <th class="mdl-data-table__cell--non-numeric">First Name</th>
                    <th class="mdl-data-table__cell--non-numeric">Last Name</th>
                    <th class="mdl-data-table__cell--non-numeric">Password</th>
                    <th class="mdl-data-table__cell--non-numeric">Admin?</th>
                    <th class="mdl-data-table__cell--non-numeric">Make Admin</th>
                    <th class="mdl-data-table__cell--non-numeric">Delte User</th>
                </tr>
                </thead>
                <tbody>
                <#list userList as theUser>
                <tr>
                    <td class="mdl-data-table__cell--non-numeric"><img
                            src="https://getmdl.io/templates/dashboard/images/user.jpg" class="demo-avatar"></td>
                    <td class="mdl-data-table__cell--non-numeric">${theUser.getUsername()}</td>
                    <td class="mdl-data-table__cell--non-numeric">${theUser.getFirstName()}</td>
                    <td class="mdl-data-table__cell--non-numeric">${theUser.getLastName()}</td>
                    <td class="mdl-data-table__cell--non-numeric">${theUser.getPassword()}</td>
                    <td class="mdl-data-table__cell--non-numeric">${theUser.isAdmin()?string('yes', 'no')}</td>
                    <td class="mdl-data-table__cell--non-numeric">
                        <#if theUser.getUsername()=="admin" || theUser.getUsername()=="guest">
                            <button class="mdl-button mdl-js-button" disabled>
                                UNEDITABLE
                            </button>
                        <#else >
                            <form action="" METHOD="POST">
                                <input type="hidden" name="username" id="username" value="${theUser.getUsername()}">
                                <#if theUser.isAdmin()>
                                    <input class="mdl-button mdl-js-button" type="submit" value="Revoke Admin">
                                <#else>
                                    <input class="mdl-button mdl-js-button" type="submit" value="Make Admin">
                                </#if>
                            </form>
                        </#if>
                    </td>
                    <td class="mdl-data-table__cell--non-numeric">
                        <#if theUser.getUsername()=="admin" || theUser.getUsername()=="guest">
                            <button class="mdl-button mdl-js-button" disabled>
                                UNDELETABLE!
                            </button>
                        <#else >
                            <form action="" METHOD="POST">
                                <input type="hidden" name="username" id="username" value="${theUser.getUsername()}">
                                <input class="mdl-button mdl-js-button" type="submit" value="Delete">
                            </form>
                        </#if>
                    </td>
                </tr>
                <#else>
                <h3>Looks like you have no users... , try adding one!</h3>
                </#list>

                </tbody>
            </table>
        </div>


    </main>
</div>


</body>