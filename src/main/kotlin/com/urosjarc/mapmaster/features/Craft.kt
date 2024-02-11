package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class CraftNode(
    val node: OsmNode,
    val type: CraftType
)

data class CraftWay(
    val way: OsmWay,
    val type: CraftType
)

data class CraftRel(
    val rel: OsmRel,
    val type: CraftType
)

data class CraftFeatures(
    val nodes: MutableList<CraftNode> = mutableListOf(),
    val ways: MutableList<CraftWay> = mutableListOf(),
    val rels: MutableList<CraftRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["craft"]
        val type = CraftType.entries.firstOrNull { it.value == enumValue }
            ?: CraftType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(CraftNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(CraftRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(CraftWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class CraftType(val value: String) {
    AGRICULTURAL_ENGINES("agricultural_engines"), // A place where engines and tools for agricultural use are planned and constructed.
    ATELIER("atelier"),                 // A place where visual artists work
    BAKERY("bakery"),                   // A workplace for fresh bakery goods. No shop.
    BASKET_MAKER("basket_maker"),       // A person weaving baskets
    BEEKEEPER("beekeeper"),             // The workplace of a beekeeper (apiarist).
    BLACKSMITH("blacksmith"),           // A place where a blacksmith forges tools, horseshoes, etc. from iron.
    BOATBUILDER("boatbuilder"),         // A workplace where boats are planned and constructed
    BOOKBINDER("bookbinder"),           // A workplace for physically assembling a book from a number of sheets of paper.
    BREWERY("brewery"),                 // A dedicated building for the making of beer.
    BUILDER("builder"),                 // A workplace or office of a tradesman who performs structural alterations and additions to buildings.
    CABINET_MAKER("cabinet_maker"),     // A person who makes fine wooden furniture
    CANDLEMAKER("candlemaker"),         // A person who makes candles or a manufactory where candles were made
    CAR_PAINTER("car_painter"),         // A place specializing in painting cars.
    CARPENTER("carpenter"),             // A workplace or office of carpenters that work with timber to construct, install and maintain buildings, furniture, and other objects.
    CARPET_LAYER("carpet_layer"),       // A carpet layer is a tradesmen who specializes in laying carpets
    CATERER("caterer"),                 // A workplace or office of one who prepares customized meals for takeout, or provides prepared meals or supplies to a group at social gatherings
    CHIMNEY_SWEEPER("chimney_sweeper"), // A workplace or office of a person who cleans chimneys for a living.
    CLEANING("cleaning"),               // Workplace or office of a person who cleaning building, industrial facilities or windows.
    CLOCKMAKER("clockmaker"),           // A workplace or office of a clockmaker that is building, repairing or engraving clocks of all sorts.
    CONFECTIONERY("confectionery"),     // A place where the set of food items that are rich in sugar, any one or type of which is called a confection is produced.
    COOPER("cooper"),                   // A person or company that manufacture of containers and vessels mainly made of wood.
    DENTAL_TECHNICIAN("dental_technician"), // A workplace for dental technician who constructs custom-made restorative and dental appliances
    DISTILLERY("distillery"),           // An establishment for distilling, especially for distilling alcoholic liquors.
    DOOR_CONSTRUCTION("door_construction"), // A workplace of someone constructing doors
    DRESSMAKER("dressmaker"),           // Dressmaker is a person who makes custom clothing for women, such as dresses, blouses, and evening gowns.
    ELECTRONICS_REPAIR("electronics_repair"), // Repair shops and service centres which provides repair of computers, phones, appliance etc.
    EMBROIDERER("embroiderer"),         // Needlework or textile artist
    ELECTRICIAN("electrician"),         // A person or company that works with electricity or electrical systems.
    ENGRAVER("engraver"),               // A workplace or office of an engraver.
    FENCE_MAKER("fence_maker"),         // Company specialized in installing fences.
    FLOORER("floorer"),                 // A workplace or office of a floorer.
    GARDENER("gardener"),               // A workplace or office of a garden designer or a landscape gardener.
    GLAZIERY("glaziery"),               // A place where residential, commercial, and artistic glass is selected, cut, installed, replaced, and removed.
    GOLDSMITH("goldsmith"),             // The workplace of a person who forges things out of gold, especially jewelry.
    GRINDING_MILL("grinding_mill"),     // A device that breaks solid materials into smaller pieces by grinding, crushing, or cutting. The aftermath is powdered product, not liquid extract like oil mill.
    HANDICRAFT("handicraft"),           // A place where useful and decorative devices are made completely by hand or using only simple tools
    HVAC("hvac"),                       // A workplace or office of an HVAC system designer (Heating, Ventilating, and Air Conditioning)
    INSULATION("insulation"),           // A workplace or office of a person who does thermal insulation in buildings.
    INTERIOR_DECORATOR("interior_decorator"), // Interior decorator.
    INTERIOR_WORK("interior_work"),     // Workplace or office of a person who build non-load-bearing interior walls, especially drywall.
    JEWELLER("jeweller"),               // A place where necklaces, rings, brooches, earrings and bracelets and other personal adornments are created or repaired.
    JOINER("joiner"),                   // An artisan who builds things by joining pieces of wood, particularly furniture or ornamental work.
    KEY_CUTTER("key_cutter"),           // A place where keys can be duplicated from originals.
    LOCKSMITH("locksmith"),             // A place where locks and keys are created or repaired.
    METAL_CONSTRUCTION("metal_construction"), // Workplace or office of a person who work with metal. This applies to: planning, construction, trade, repair.
    MINT("mint"),                       // A place where coins and medals are hand crafted.
    MUSICAL_INSTRUMENT("musical_instrument"), // A craftsman creating musical instruments
    OIL_MILL("oil_mill"),               // A mill designed to crush or bruise oil-bearing seeds, such as linseed or peanuts, or other oil-rich vegetable material.
    OPTICIAN("optician"),               // A place where lenses for the correction of a person's vision are designed, fitted and dispensed.
    ORGAN_BUILDER("organ_builder"),     // Organ building is the profession of designing, building, restoring and maintaining pipe organs.
    PAINTER("painter"),                 // A workplace or office of a house painter which is a tradesman responsible for the painting and decorating of buildings.
    PARQUET_LAYER("parquet_layer"),     // A workplace or office of a parquet layer.
    PAVER("paver"),                     // The workshop or office of a paver
    PEST_CONTROL("pest_control"),       // A business that offers pest control services
    PHOTOGRAPHER("photographer"),       // A workplace or office of a person who takes photographs using a camera.
    PHOTOGRAPHIC_LABORATORY("photographic_laboratory"), // A place where photos taken on a film or digital images are transformed into a more permanent form, often on paper or plastic foil.
    PHOTOVOLTAIC("photovoltaic"),       // A workplace or office who installed or planned photovoltaic systems.
    PIANO_TUNER("piano_tuner"),         // A piano tuner or technician. A professional that tunes, regulates and makes the maintenance of pianos. Most of them repair simple problems and some restore a whole piano.
    PLASTERER("plasterer"),             // A workplace or office of a tradesman who works with plaster, such as forming a layer of plaster on an interior wall or plaster decorative moldings on ceilings or walls.
    PLUMBER("plumber"),                 // A workplace or office of a skilled tradesperson who specializes in (drinking) water supply, sewage and drainage systems
    POTTERY("pottery"),                 // A place where earthenware, stoneware and porcelain and other ceramic ware is made by potters.
    PRINTER("printer"),                 // A small printing business which produces published works such as newspapers, books, magazines, etc.
    PRINTMAKER("printmaker"),           // A producer of fine art prints.
    RESTORATION("restoration"),         // Restorer.
    RIGGER("rigger"),                   // The workplace of a person who sets up the rigging for sailboats and sailing ships (or possibly a person who works on ropes, booms, lifts, hoists and the like for a stage production)
    ROOFER("roofer"),                   // A workplace or office of a tradesman who is specialized in roof covering and sealing.
    SADDLER("saddler"),                 // A place where saddles or accessories for cars and boats are produced or repaired.
    SAILMAKER("sailmaker"),             // A workshop of a sailmaker who cleans, repairs and makes sails.
    SAWMILL("sawmill"),                 // A sawmill is a facility where logs are cut into timber
    SCAFFOLDER("scaffolder"),           // A workplace or office of a tradesman who builds temporary structure used to support people and material in the construction or repair of buildings and other large structures.
    SCULPTOR("sculptor"),               // The workplace of a sculptor.
    SHOEMAKER("shoemaker"),             // A place where shoes, boots, sandals, clogs and moccasins are created, repaired or altered to fit personal needs.
    SIGNMAKER("signmaker"),             // A maker of signs, mainly for shops and other businesses.
    STAND_BUILDER("stand_builder"),     // A workplace of a company that builds stands/booths for fairs.
    STONEMASON("stonemason"),           // A place where rough pieces of rock are shaped into accurate geometrical shapes.
    STOVE_FITTER("stove_fitter"),       // A workplace/office of a person / company who designs and builds stoves / tiled stoves.
    SUN_PROTECTION("sun_protection"),   // A place where sun protection is made, repaired, or delivered for assembly, especially awnings and shutters.
    TAILOR("tailor"),                   // A place where clothing is made, repaired, or altered professionally, especially suits and men's clothing.
    TILER("tiler"),                     // A workplace or office of a person who lays tiles on floors, swimming pools and such.
    TINSMITH("tinsmith"),               // A person who makes and repairs things made of light-coloured metal, particularly tinware.
    TOOLMAKER("toolmaker"),             // A workplace of a company that builds complex tools, machine tools, moulds, gauges,... .
    TURNER("turner"),                   // A workplace or office of a turner.
    UPHOLSTERER("upholsterer"),         // A place where furniture, especially seats are provided with padding, springs, webbing, and fabric or leather covers.
    WATCHMAKER("watchmaker"),           // A watchmaker is an artisan who makes and repairs watches. Today due to industrial production they mostly repair watches.
    WATER_WELL_DRILLING("water_well_drilling"), // A company that drills water wells.
    WINDOW_CONSTRUCTION("window_construction"), // A workplace of someone constructing windows
    WINERY("winery"),                   // A place where wine is produced
    OTHER("other")
}
