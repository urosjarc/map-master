			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class AccessNode(
                val node: OsmNode,
                val type: AccessType
            )

            data class AccessWay(
                val way: OsmWay,
                val type: AccessType
            )

            data class AccessRel(
                val rel: OsmRel,
                val type: AccessType
            )

            data class AccessFeatures(
                val nodes: MutableList<AccessNode> = mutableListOf(),
                val ways: MutableList<AccessWay> = mutableListOf(),
                val rels: MutableList<AccessRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["access"]
                    val type = AccessType.entries.firstOrNull { it.value == enumValue }
                        ?: AccessType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(AccessNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(AccessRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(AccessWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class AccessType(val value: String) {
                DESIGNATED("designated"),           // General access permission. agricultural – Only for agricultural traffic delivery – Only when delivering to the element. designated – A preferred or designated route for a specific vehicle type or types. Not compulsory but often marked by a traffic sign destination – Used for ways in designated local traffic areas, where traffic should only enter if its destination is within the area forestry – Only for forestry traffic no – No access for the general public. Consider using another tag indicating who can use the element official – The way is dedicated to a specific mode of travel by law. Usually marked by traffic signs and exclusive. In Germany use is also compulsory. clarification needed permissive – Open to general traffic until such time as the owner revokes the permission which they are legally allowed to do at any time in the future. private – Only with permission of the owner on an individual basis yes – The public has an official, legal right of access, i.e. it's a right of way (default value)
                OTHER("other")
            }