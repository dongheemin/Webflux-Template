package net.donggul.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import net.donggul.api.search.SearchParam
import org.springframework.util.MultiValueMap
import java.util.LinkedList

fun searchParam(om: ObjectMapper, map: MultiValueMap<String, String>): SearchParam = SearchParam(
    map.getFirst("page")?.toIntOrNull(),
    map.getFirst("limit")?.toIntOrNull(),
    map.getFirst("sort_by"),
    map.getFirst("asc")?.toBoolean(),
    if (map.containsKey("filters"))
        om.readValue(
            map.getFirst("filters"),
            om.typeFactory.constructCollectionType(MutableList::class.java, SearchParam.Filter::class.java)
        )
    else LinkedList()
)