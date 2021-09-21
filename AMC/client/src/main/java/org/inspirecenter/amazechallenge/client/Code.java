package org.inspirecenter.amazechallenge.client;

import java.util.Random;

public class Code {

    public static final String LEFT_WALL_FOLLOWER = "var justTurned;\n" +
            "\n" +
            "\n" +
            "function init(instance) {\n" +
            "  populatePropNames();\n" +
            "  justTurned = false;\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "}/*end init()*/\n" +
            "\n" +
            "function run(instance) {\n" +
            "  populatePropNames();\n" +
            "  var __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.NO_MOVE;\n" +
            "  propNames.forEach(function(item, index) {\n" +
            "      var mapValue = instance.getJavascriptArgument(item);\n" +
            "      if (mapValue == 'false') this[item] = false;\n" +
            "      else if (mapValue == 'true') this[item] = true;\n" +
            "      else if (!isNaN(mapValue)) this[item] = Number(mapValue);\n" +
            "      else if (mapValue == 'north') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.NORTH;\n" +
            "      else if (mapValue == 'south') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.SOUTH;\n" +
            "      else if (mapValue == 'west') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.WEST;\n" +
            "      else if (mapValue == 'east') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.EAST;\n" +
            "  });\n" +
            "\n" +
            "\n" +
            "/*---- PLAYER'S CODE ----*/\n" +
            "\n" +
            "  if (justTurned && (instance.canMoveForward())) {\n" +
            "    justTurned = false;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "  if (instance.canMoveLeft()) {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else if (instance.canMoveForward()) {\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "/*---------------------*/\n" +
            "\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "  return __retVal;\n" +
            "}/*end run()*/";

    public static final String RIGHT_WALL_FOLLOWER = "var justTurned;\n" +
            "\n" +
            "\n" +
            "function init(instance) {\n" +
            "  populatePropNames();\n" +
            "  justTurned = false;\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "}/*end init()*/\n" +
            "\n" +
            "function run(instance) {\n" +
            "  populatePropNames();\n" +
            "  var __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.NO_MOVE;\n" +
            "  propNames.forEach(function(item, index) {\n" +
            "      var mapValue = instance.getJavascriptArgument(item);\n" +
            "      if (mapValue == 'false') this[item] = false;\n" +
            "      else if (mapValue == 'true') this[item] = true;\n" +
            "      else if (!isNaN(mapValue)) this[item] = Number(mapValue);\n" +
            "      else if (mapValue == 'north') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.NORTH;\n" +
            "      else if (mapValue == 'south') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.SOUTH;\n" +
            "      else if (mapValue == 'west') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.WEST;\n" +
            "      else if (mapValue == 'east') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.EAST;\n" +
            "  });\n" +
            "\n" +
            "\n" +
            "/*---- PLAYER'S CODE ----*/\n" +
            "\n" +
            "  if (justTurned && (instance.canMoveForward())) {\n" +
            "    justTurned = false;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "  if (instance.canMoveRight()) {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else if (instance.canMoveForward()) {\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "/*---------------------*/\n" +
            "\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "  return __retVal;\n" +
            "}/*end run()*/";

    public static final String COMPASS_SOLVER = "function run(instance) {\n" +
            "  populatePropNames();\n" +
            "  var __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.NO_MOVE;\n" +
            "  propNames.forEach(function(item, index) {\n" +
            "      var mapValue = instance.getJavascriptArgument(item);\n" +
            "      if (mapValue == 'false') this[item] = false;\n" +
            "      else if (mapValue == 'true') this[item] = true;\n" +
            "      else if (!isNaN(mapValue)) this[item] = Number(mapValue);\n" +
            "      else if (mapValue == 'north') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.NORTH;\n" +
            "      else if (mapValue == 'south') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.SOUTH;\n" +
            "      else if (mapValue == 'west') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.WEST;\n" +
            "      else if (mapValue == 'east') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.EAST;\n" +
            "  });\n" +
            "\n" +
            "\n" +
            "/*---- PLAYER'S CODE ----*/\n" +
            "\n" +
            "  if ((instance.compass()) == (instance.onMove((Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD)))) {\n" +
            "    if (instance.canMoveForward()) {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    } else {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    }\n" +
            "  } else if ((instance.compass()) == (instance.onMove((Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE)))) {\n" +
            "    if (instance.canMoveRight()) {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    } else if (instance.canMoveForward()) {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    } else {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    }\n" +
            "  } else if ((instance.compass()) == (instance.onMove((Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE)))) {\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else {\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "/*---------------------*/\n" +
            "\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "  return __retVal;\n" +
            "}/*end run()*/";

    public static final String RANDOM_WALK_SOLVER = "var justTurned, randomChoice;\n" +
            "\n" +
            "\n" +
            "function init(instance) {\n" +
            "  populatePropNames();\n" +
            "  justTurned = false;\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "}/*end init()*/\n" +
            "\n" +
            "function run(instance) {\n" +
            "  populatePropNames();\n" +
            "  var __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.NO_MOVE;\n" +
            "  propNames.forEach(function(item, index) {\n" +
            "      var mapValue = instance.getJavascriptArgument(item);\n" +
            "      if (mapValue == 'false') this[item] = false;\n" +
            "      else if (mapValue == 'true') this[item] = true;\n" +
            "      else if (!isNaN(mapValue)) this[item] = Number(mapValue);\n" +
            "      else if (mapValue == 'north') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.NORTH;\n" +
            "      else if (mapValue == 'south') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.SOUTH;\n" +
            "      else if (mapValue == 'west') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.WEST;\n" +
            "      else if (mapValue == 'east') this[item] = Packages.org.inspirecenter.amazechallenge.proto.Direction4.EAST;\n" +
            "  });\n" +
            "\n" +
            "\n" +
            "/*---- PLAYER'S CODE ----*/\n" +
            "\n" +
            "  if (justTurned) {\n" +
            "    justTurned = false;\n" +
            "    if (instance.canMoveForward()) {\n" +
            "      __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "      propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "      return __retVal;\n" +
            "    }\n" +
            "  }\n" +
            "  randomChoice = (_getRandomInt(0, 3));\n" +
            "  if (randomChoice == 0) {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else if (randomChoice == 1) {\n" +
            "    justTurned = true;\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  } else if (randomChoice == 2) {\n" +
            "    __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" +
            "    propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "    return __retVal;\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "/*---------------------*/\n" +
            "\n" +
            "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
            "  return __retVal;\n" +
            "}/*end run()*/";

    public static String getRandomCode() {
        Random random = new Random();
        String[] codes = {
                RIGHT_WALL_FOLLOWER,
                LEFT_WALL_FOLLOWER,
//                COMPASS_SOLVER,
//                RANDOM_WALK_SOLVER
        };
        return codes[random.nextInt(codes.length)];
    }

}
