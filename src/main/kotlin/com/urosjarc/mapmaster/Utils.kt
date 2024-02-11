package com.urosjarc.mapmaster

import me.xdrop.fuzzywuzzy.FuzzySearch

object Utils {
    fun search(query: String, choices: Collection<String>, limit: Int): List<OsmMatch> =
        FuzzySearch.extractSorted(query, choices, limit).map {
            OsmMatch(match = it.string, score = it.score)
        }
}
