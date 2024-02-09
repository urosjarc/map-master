package com.urosjarc.mapmaster.domain

data class Sport(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		NINE_PIN("9pin"),                   // A bowling game played in Europe with only 9 pins.
		TEN_PIN("10pin"),                   // A bowling game popular in North America with 10 pins.
		AEROBICS("aerobics"),               // Aerobics
		AMERICAN_FOOTBALL("american_football"), // A sport played by two teams of eleven players on a rectangular field with goalposts at each end.
		AIKIDO("aikido"),                   // A Japanese martial art by blending with the motion of the attacker and redirecting the force of the attack rather than opposing it head-on.
		ARCHERY("archery"),                 // The art, practice, or skill of propelling arrows with the use of a bow.
		ATHLETICS("athletics"),             // A collection of sports which combines various athletic contests based on the skills of running, jumping, and throwing.
		AUSTRALIAN_FOOTBALL("australian_football"), // A sport played between two teams of eighteen players on an oval field, also called football, footy, Aussie rules, or AFL.
		BADMINTON("badminton"),             // A racquet sport played by singles or in teams of two, who take positions on opposite halves of a rectangular court (pitch) divided by a net.
		BANDY("bandy"),                     // Bandy is a sport played by two teams of eleven players on a rectangular field.
		BASEBALL("baseball"),               // A bat-and-ball game played between two teams of nine players on a field (pitch or stadium) each who take turns batting and fielding.
		BASKETBALL("basketball"),           // A sport played by two teams of five players on a rectangular court.
		BEACHVOLLEYBALL("beachvolleyball"), // Volleyball played on a sand court
		BIATHLON("biathlon"),               // The biathlon is a winter sport that combines cross-country skiing and rifle shooting.
		BILLIARDS("billiards"),             // Cue sports, a wide variety of games of skill generally played with a cue stick which is used to strike billiard balls, moving them around a cloth-covered billiards table bounded by rubber cushions.
		BMX("bmx"),                         // A cycle sport performed on BMX bikes, either in competitive BMX racing or freestyle BMX, or else in general on- or off-road recreation.
		BOBSLEIGH("bobsleigh"),             // A winter sport in which teams of two or four make timed runs down narrow, twisting, banked, iced tracks in a gravity-powered sled, also called luge or bobslede.
		BOULES("boules"),                   // A group of games in which the objective is to throw or roll heavy balls as close as possible to a small target ball, also called pétanque, lyonnaise, bocce, or bocce volo.
		BOWLS("bowls"),                     // Sport in which the objective is to roll biased balls so that they stop close to a smaller ball
		BOXING("boxing"),                   // Boxing is a combat sport in which two people engage in a contest by throwing punches with gloved hands against each other.
		BULLFIGHTING("bullfighting"),       // Bullfighting, both on foot and on horseback, is a physical contest in which bulls are fought by humans.
		CANADIAN_FOOTBALL("canadian_football"), // A sport played by two teams of 12 players on a rectangular field with goal posts at each end.
		CANOE("canoe"),                     // Paddle propelled lightweight narrow boats.
		CHESS("chess"),                     // Chess is a popular two-player strategy board game.
		CLIFF_DIVING("cliff_diving"),       // Non-competitive diving is jumping from a cliff or a rock into water.
		CLIMBING("climbing"),               // Marks elements to represent natural climbing sites (climbing areas, sectors, crags, frozen waterfalls, etc.) or artificial climbs (climbing walls, indoor climbing halls, etc.)
		CLIMBING_ADVENTURE("climbing_adventure"), // An Adventure Park, where people climb, walk or otherwise move on prebuilt wires and other objects.
		COCKFIGHTING("cockfighting"),       // A blood sport between two roosters (cocks), or more accurately gamecocks, held in a ring called a cockpit.
		CRICKET("cricket"),                 // A bat-and-ball sport contested by two teams, usually of eleven players, each on a large grass Cricket pitch. Played on a large circular or oval-shaped grassy Cricket field ground.
		CROSSFIT("crossfit"),               // CrossFit, a branded fitness regimen
		CROQUET("croquet"),                 // A sport or game that is played between two or more players embedded on a small grass playing court or pitch which involves hitting plastic or wooden balls with a mallet through hoops (often called "wickets" in the United States).
		CURLING("curling"),                 // A sport in which players slide stones on a sheet of ice towards a target area which is segmented into four concentric rings.
		CYCLE_POLO("cycle_polo"),           // A cycle polo
		CYCLING("cycling"),                 // The use of bicycles for sport, also called bicycling, mountain biking or biking.
		DARTS("darts"),                     // Darts is a form of throwing game in which small missiles are thrown at a circular target (dartboard) fixed to a wall.
		DOG_AGILITY("dog_agility"),         // Dog agility is a dog sport in which a handler directs a dog through an obstacle course in a race for both time and accuracy.
		DOG_RACING("dog_racing"),           // A feature used for dog racing
		DRAGON_BOAT("dragon_boat"),         // Ancient Chinese boat
		EQUESTRIAN("equestrian"),           // A sport practised with the horse as a partner; but for horse racing use tag:sport=horse_racing.
		FENCING("fencing"),                 // Fencing is the martial art of fighting with blades. Divided into three weapon categories: foil, sabre (spelled saber in the United States) and épée.
		FIELD_HOCKEY("field_hockey"),       // A stick and ball game played on a rectangular court with goals at either end.
		FITNESS("fitness"),                 // To develop physical fitness
		FIVE_A_SIDE("five-a-side"),         // A variation of soccer with only 5 persons per team on a smaller pitch
		FLOORBALL("floorball"),             // Floorball is a type of floor hockey with five players and a goalkeeper in each team.
		FOUR_SQUARE("four_square"),         // A hand ball game played on a square court.
		FREE_FLYING("free_flying"),         // Provides a way to tag landing and takeoff for free flying aircraft with additional related amenities.
		FUTSAL("futsal"),                   // Futsal is a sport played by two teams of five players on a rectangular court.
		GAELIC_GAMES("gaelic_games"),       // Gaelic Games as played within the GAA in Ireland, including Gaelic Football, Hurling, Ladies Gaelic Football, Camogie, Handball and Rounders
		GAGA("gaga"),                       // Gaga (or gaga ball) is a variant of dodgeball that is played in a gaga "pit"
		GOLF("golf"),                       // a stick and ball game played from a 'tee' to a hole.
		GYMNASTICS("gymnastics"),           // Gymnastics
		HANDBALL("handball"),               // A team sport played with goals and a thrown ball using the hands.
		HAPKIDO("hapkido"),                 // A dynamic and highly eclectic Korean martial art
		HIKING("hiking"),                   // Going for a long, vigorous walk, usually on trails or footpaths in the countryside.
		HORSESHOES("horseshoes"),           // Throwing horseshoes at a peg target.
		HORSE_RACING("horse_racing"),       // An equestrian sport in which several horses simultaneously race against each other.
		ICE_HOCKEY("ice_hockey"),           // A ball and stick game played on an ice rink.
		ICE_SKATING("ice_skating"),         // A sport or pastime by moving on ice while using ice skates.
		ICE_STOCK("ice_stock"),             // Ice stock sport, also known as Bavarian curling, is a winter sport, somewhat similar to curling. In German, it is known as Eisstockschießen.
		JUDO("judo"),                       // Judo: a modern Japanese martial art, combat and Olympic sport.
		KARATE("karate"),                   // Martial art.
		KARTING("karting"),                 // A motorized race using small open four wheeled vehicles.
		KICKBOXING("kickboxing"),           // Kickboxing is a group of stand-up combat sports based on kicking and punching.
		KITESURFING("kitesurfing"),         // Property added to a sports facility to mark as used for kitesurfing
		KORFBALL("korfball"),               // Korfball: a team sport played with a ball on a rectangular court
		KRACHTBAL("krachtbal"),             // Team sport played with a heavy ball on a rectangular pitch, originating in West-Flanders, Belgium
		LACROSSE("lacrosse"),               // A team sport played with a lacrosse stick and a lacrosse ball. Players use the head of the lacrosse stick to carry pass, catch, and shoot the ball into the goal.
		LASER_TAG("laser_tag"),             // Laser tag is a tag game played in an arena.
		MARTIAL_ARTS("martial_arts"),       // Codified systems and traditions of combat practices
		MINIATURE_GOLF("miniature_golf"),   // Miniature golf, also known as minigolf, mini-putt, crazy golf, or putt-putt, is an offshoot of the sport of golf focusing solely on the putting aspect of its parent game.
		MODEL_AERODROME("model_aerodrome"), // Where RC model aircraft are flown.
		MOTOCROSS("motocross"),             // Motorcycle racing on unpaved surfaces.
		MOTOR("motor"),                     // Motorsport: a sport with motorised vehicles, e.g. auto racing
		MULTI("multi"),                     // Property added to otherwise marked sports facility to indicate as suitable for more than one sport, without listing them
		NETBALL("netball"),                 // A hand ball competition between two teams on a rectangular court.
		OBSTACLE_COURSE("obstacle_course"), // A series of challenging physical obstacles an individual or team must navigate, usually while being timed.
		ORIENTEERING("orienteering"),       // Orienteering
		PADDLE_TENNIS("paddle_tennis"),     // Paddle tennis is a racquet sport adapted from tennis and played for over a century.
		PADEL("padel"),                     // A racket sport played in pairs. It consists of bouncing the ball in the opponent's court, with the possibility of bouncing it off the walls.
		PAINTBALL("paintball"),             // A game in which players mark their opponents with colored paint capsules shot out of an air gun.
		PARACHUTING("parachuting"),         // Parachuting / Skydiving
		PARKOUR("parkour"),                 // Parkour is a training discipline using movement that developed from military obstacle course training.
		PELOTA("pelota"),                   // Pelota, a variety of court sports played with a ball using one's hand, a racket, a wooden bat (pala), or a basket propulsor (txistera), against a wall or with two teams.
		PESÄPALLO("pesäpallo"),             // Pesäpallo, sometimes known as Finnish baseball, is a fast-moving bat-and-ball sport where the offense tries to score by hitting the ball successfully and running through the bases, while the defense tries to put the batter and runners out.
		PICKLEBALL("pickleball"),           // Pickleball, a tennis-like game played with a slower ball on a smaller court.
		PILATES("pilates"),                 // Pilates is a physical fitness system developed in the early 20th century by Joseph Pilates.
		DANCE("dance"),                     // Generic dance sport
		POLE_DANCE("pole_dance"),           // Pole dance as kind of sport
		RACQUET("racquet"),                 // Racquetball is a racquet sport played with a hollow rubber ball
		RC_CAR("rc_car"),                   // Model cars/trucks that are radio-controlled.
		ROLLER_SKATING("roller_skating"),   // The travelling on surfaces with roller skates.
		ROWING("rowing"),                   // Additional tag added on object to mark them as used for sport of rowing
		RUGBY_LEAGUE("rugby_league"),       // A ball game using both feet and hands between two teams.
		RUGBY_UNION("rugby_union"),         // A ball game using hands and feet between two teams.
		RUNNING("running"),                 // Human propulsion using legs and feet only.
		SAILING("sailing"),                 // Sailing: the sport of using wind to power sails which propel a boat
		SCUBA_DIVING("scuba_diving"),       // To mark a physical object as for scuba diving
		SHOOTING("shooting"),               // Firing weapons at a target.
		SHOT_PUT("shot-put"),               // Shot-put is a sport involving throwing a heavy spherical object as far as possible.
		SKATEBOARD("skateboard"),           // An area designated and equipped for skateboarding
		SKI_JUMPING("ski_jumping"),         // Ski jumping is a winter sport in which competitors aim to achieve the longest jump after descending from a specially designed ramp on their skis.
		SKIING("skiing"),                   // Identifies given object as related to skiing.
		SNOOKER("snooker"),                 // Snooker is a cue sport that is played on a rectangular table covered with a green cloth with pockets at each of the four corners and in the middle of each long side.
		SOCCER("soccer"),                   // Association football, more commonly known as football or soccer
		SOFTBALL("softball"),               // A bat-and-ball game similar to baseball.
		SPEEDWAY("speedway"),               // Motorcycle speedway, usually referred to as speedway, is a motorcycle sport involving four and sometimes up to six riders competing over four anti-clockwise laps of an oval circuit.
		SQUASH("squash"),                   // Squash is a racket and ball sport played by two or four players in a four-walled court with a small, hollow rubber ball.
		SUMO("sumo"),                       // A traditional martial arts sport of Japan.
		SURFING("surfing"),                 // Person riding a wave using a board.
		SWIMMING("swimming"),               // A place where people swim for sport.
		TABLE_TENNIS("table_tennis"),       // A bat and ball game played over a table.
		TABLE_SOCCER("table_soccer"),       // Table Soccer or Table Football, also known as Foosball, Fussball, Kicker, or Tecball, is a table-top game and sport based off association football (soccer).
		TAEKWONDO("taekwondo"),             // Korean martial art.
		TENNIS("tennis"),                   // A competition where two or four players use a ball and rackets over a net.
		TEQBALL("teqball"),                 // Place for playing teqball.
		TOBOGGAN("toboggan"),               // Added on toboggan runs, toboggan sport shops etc
		TRUGO("trugo"),                     // A game which involves hitting a rubber ring with a wooden mallet to a goal on a grass pitch.
		ULTIMATE("ultimate"),               // Ultimate, also known as ultimate frisbee, is a team sport played with a flying disc (frisbee).
		VOLLEYBALL("volleyball"),           // A hand ball sport played by two teams over a net.
		WAKEBOARDING("wakeboarding"),       // Wakeboarding is a water sport in which the rider, standing on a wakeboard, is towed behind a motorboat in order to perform aerial maneuvers.
		WATER_POLO("water_polo"),           // A competitive ball sport played in a pool between two teams.
		WATER_SKI("water_ski"),             // Person on a board pulled over water by a boat or cable.
		WEIGHTLIFTING("weightlifting"),     // Recreational weightlifting.
		WINDSURFING("windsurfing"),         // Wind powered board on water.
		WRESTLING("wrestling"),             // Wrestling
		YOGA("yoga"),                       // Fitness improvement by forming different postures.
		ZURKHANEH_SPORT("zurkhaneh_sport"), // A traditional system of athletics.
	}
}