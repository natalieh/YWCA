

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'careerPage.label', default: 'CareerPage')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'careerPage.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="title" title="${message(code: 'careerPage.title.label', default: 'Title')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'careerPage.description.label', default: 'Description')}" />
                        
                            <th><g:message code="careerPage.owner.label" default="Owner" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${careerPageInstanceList}" status="i" var="careerPageInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${careerPageInstance.id}">${fieldValue(bean: careerPageInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: careerPageInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: careerPageInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: careerPageInstance, field: "owner")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${careerPageInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
