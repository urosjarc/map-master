package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class LanduseNode(
    val node: OsmNode,
    val type: LanduseType
)

data class LanduseWay(
    val way: OsmWay,
    val type: LanduseType
)

data class LanduseRel(
    val rel: OsmRel,
    val type: LanduseType
)

data class LanduseFeatures(
    val nodes: MutableList<LanduseNode> = mutableListOf(),
    val ways: MutableList<LanduseWay> = mutableListOf(),
    val rels: MutableList<LanduseRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["landuse"]
        val type = LanduseType.entries.firstOrNull { it.value == enumValue }
            ?: LanduseType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(LanduseNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(LanduseRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(LanduseWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class LanduseType(val value: String) {
    COMMERCIAL("commercial"),           // Predominantly commercial businesses and their offices. Commercial businesses which sell goods should be categorised as landuse=retail. Commercial businesses can sell services on site and may include private Doctor's Surgeries, and those non-government services for mental and physical health, such as a Counselor's or Physiotherapist's practice or Veterinary. Commercial businesses can also include office buildings and business parks which have limited interface with the public and sell their services either on site, or externally. Commercial businesses have low amounts of public foot traffic. Government services and businesses predominantly mapped as commercial too and used as such by data consumers! See more information on operator:type to set it as government to distinguish from private or others. civic_admin is an abandoned proposal, civic has no documentation, institutional is to ambiguous and all three only find minimal support in the mapping community.
    CONSTRUCTION("construction"),       // A site which is under active development and construction of a building or structure, including any purposeful alteration to the land or vegetation upon it. Abandoned construction projects and sites should not use this tag.
    EDUCATION("education"),             // An area predominately used for educational purposes/facilities.
    FAIRGROUND("fairground"),           // A site where a fair takes place
    INDUSTRIAL("industrial"),           // Predominantly industrial landuses such as workshops, factories, or warehouses.
    RESIDENTIAL("residential"),         // Land where people reside; predominantly residential detached (single houses, grouped dwellings), or attached (apartments, flats, units) dwellings. For "Mixed-Use" areas where more than half of the land is residential, tag as residential. See also: [[:Land use and areas of natural land § Open questions]]
    RETAIL("retail"),                   // Predominantly retail businesses such as shops. Retail businesses sell physical goods such as food (prepared or grocery), clothing, medicine, stationary, appliances, tools, or other similar physical items. Retail businesses have high amounts of public foot traffic. Retail businesses do not exclusively provide or sell their services. For businesses which sell services see landuse=commercial. Generally a member of the public could freely walk into and access a retail business. Retail is a subset of commercial, but should be used and treated as mutually exclusive in OpenStreetMap.
    INSTITUTIONAL("institutional"),     // Land used for institutional purposes, see Institution (disambiguation). Institutional land may include buildings like an office=government, office=ngo, office=association, amenity=social_facility and their associated infrastructure (car parks, service roads, yards and so-on) The meaning of this tag is ambiguous and unclear. Consider using another tag that better describes the object. For instance landuse=commercial. See talk page for discussion.
    AQUACULTURE("aquaculture"),         // Aquaculture is the farming of freshwater and saltwater organisms such as finfish, molluscs, crustaceans and aquatic plants. Warning: currently, there is no convention on the exact meaning of this tag. Therefore, it makes sense to treat it like "boundary of aquaculture" (without implication of water body), which means, water body should be tagged by its own, using natural=water etc.
    ALLOTMENTS("allotments"),           // A piece of land given over to local residents for growing vegetables and flowers.
    FARMLAND("farmland"),               // An area of farmland used for tillage (cereals, vegetables, oil plants, flowers).
    FARMYARD("farmyard"),               // An area of land with farm buildings like farmhouse, dwellings, farmsteads, sheds, stables, barns, equipment sheds, feed bunkers, etc. plus the open space in between them and the shrubbery/trees around them.
    PADDY("paddy"),                     // An area of land where the surface and shape of the land is made suitable for growing rice.
    ANIMAL_KEEPING("animal_keeping"),   // An area of land that is used to keep animals, particularly horses and livestock.
    FLOWERBED("flowerbed"),             // An area designated for flowers
    FOREST("forest"),                   // Managed forest or woodland plantation (Other languages). Some use this to map an area of trees rather than the use of the land. See Forest.
    GREENHOUSE_HORTICULTURE("greenhouse_horticulture"), // Area used for growing plants in greenhouses
    MEADOW("meadow"),                   // A meadow or pasture: land primarily vegetated by grass and non-woody plants, mainly used for hay or grazing
    ORCHARD("orchard"),                 // intentional planting of trees or shrubs maintained for food production
    PLANT_NURSERY("plant_nursery"),     // intentional planting of plants maintaining for the production of new plants
    VINEYARD("vineyard"),               // A piece of land where grapes are grown.
    BASIN("basin"),                     // An area artificially graded to hold water. Together with basin=* for stormwater/rainwater infiltration/detention/retention basins. Other languages.
    RESERVOIR("reservoir"),             // A reservoir on Wikipedia. Deprecated variant of natural=water + water=reservoir. See Proposed features/Reservoir for details.
    SALT_POND("salt_pond"),             // A place where salt (saline) water is evaporated to extract its salt.
    BROWNFIELD("brownfield"),           // Describes land scheduled for new development where old buildings have been demolished and cleared
    CEMETERY("cemetery"),               // Place for burials. You can add religion=* (values listed in the place of worship page). Smaller places (e.g. with a church nearby) may use amenity=grave_yard instead.
    CONSERVATION("conservation"),       // Protected areas (deprecated) Alternate tagging of same thing: boundary=protected_area, protected_area=*
    DEPOT("depot"),                     // An area used as a depot for e.g. vehicles (trains, buses or trams). Consider using rather standard landuse tags like landuse=railway, landuse=commercial, landuse=industrial, with subtag like industrial=depot.
    GARAGES("garages"),                 // One level buildings with boxes commonly for cars, usually made of brick and metal. Usually this area belong to garage cooperative with own name, chairman, budget, rules, security, etc.
    GRASS("grass"),                     // An area of mown and managed grass not otherwise covered by a more specific tag. Some view this as not a landuse, see the main page landuse=grass for discussion.
    GREENFIELD("greenfield"),           // Describes land scheduled for new development where there have been no buildings before. A greenfield is scheduled to turn into a construction site
    LANDFILL("landfill"),               // Place where waste is dumped.
    MILITARY("military"),               // For land areas owned/used by the military for whatever purpose
    PORT("port"),                       // coastal industrial area where commercial traffic is handled. Consider using landuse=industrial + industrial=port for this type of industrial area.
    QUARRY("quarry"),                   // Surface mineral extraction
    RAILWAY("railway"),                 // Area for railway use, generally off-limits to the general public
    RECREATION_GROUND("recreation_ground"), // An open green space for general recreation, which may include pitches, nets and so on, usually municipal but possibly also private to colleges or companies
    RELIGIOUS("religious"),             // An area used for religious purposes
    VILLAGE_GREEN("village_green"),     // A village green is a distinctive area of grassy public land in a village centre. Not a generic tag for urban greenery. It is a typical English term – defined separately from 'common land' under the Commons Registration Act 1965 and the Commons Act 2006.
    WINTER_SPORTS("winter_sports"),     // An area dedicated to winter sports (e.g. skiing)
    OTHER("other")
}
