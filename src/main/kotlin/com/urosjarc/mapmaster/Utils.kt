package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.MapMatch
import me.xdrop.fuzzywuzzy.FuzzySearch

object Utils {
    fun search(query: String, choices: Collection<String>, limit: Int): List<MapMatch> =
        FuzzySearch.extractSorted(query, choices, limit).map {
            MapMatch(match = it.string, distance = 100.0 - it.score)
        }
}
