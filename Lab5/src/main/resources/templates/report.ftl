Catalog Name: ${catalog.catalogName}

Documents:
<#list catalog.documentList as doc>
    Title: ${doc.title}
    Location: ${doc.location}
    Tags:
    <#list doc.tags?keys as tag>
        ${tag}: ${doc.tags[tag]}
    </#list>
</#list>