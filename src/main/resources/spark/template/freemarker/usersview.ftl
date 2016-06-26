<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">

    <main class="mdl-layout__content mdl-color--grey-100">


        <table class="custom-table mdl-data-table mdl-js-data-table">
            <thead>
            <tr>
                <th class="mdl-data-table__cell--non-numeric">Username</th>
                <th class="mdl-data-table__cell--non-numeric">First Name</th>
                <th class="mdl-data-table__cell--non-numeric">Last Name</th>
                <th class="mdl-data-table__cell--non-numeric">Password</th>
                <th class="mdl-data-table__cell--non-numeric">Admin?</th>
                <th class="mdl-data-table__cell--non-numeric">Make Admin</th>
            </tr>
            </thead>
            <tbody>
            <#list userList as user>
            <tr>
                <td class="mdl-data-table__cell--non-numeric">${user.getUsername()}</td>
                <td class="mdl-data-table__cell--non-numeric">${user.getFirstName()}</td>
                <td class="mdl-data-table__cell--non-numeric">${user.getLastName()}</td>
                <td class="mdl-data-table__cell--non-numeric">${user.getPassword()}</td>
                <td class="mdl-data-table__cell--non-numeric">${user.isAdmin()?string('yes', 'no')}</td>
                <td class="mdl-data-table__cell--non-numeric">
                    <form action="" METHOD="POST">
                        <input type="hidden" name="username" id="username" value="${user.getUsername()}">
                        <#if user.isAdmin()>
                            <input class="mdl-button mdl-js-button" type="submit" value="Revoke Admin">
                        <#else>
                            <input class="mdl-button mdl-js-button" type="submit" value="Make Admin">
                        </#if>
                    </form>



                </td>
            </tr>
            <#else>
            <h3>Looks like you have no users... , try adding one!</h3>
            </#list>

            </tbody>
        </table>




    </main>
</div>


</body>