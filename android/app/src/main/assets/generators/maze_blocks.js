Blockly.JavaScript['maze_move_forward'] = function(block) {
  var code = "__retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD;\n" + //Change return value to MOVE_FORWARD
  "propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" + //Save variable to map before returning
  "return __retVal;\n"; //return to Java
  return code;
};

Blockly.JavaScript['maze_turn_cw'] = function(block) {
  var code = "__retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE;\n" + //Change return value to TURN_CLOCKWISE
    "propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" + //Save variable to map before returning
    "return __retVal;\n"; //return to Java
  return code;
};

Blockly.JavaScript['maze_turn_ccw'] = function(block) {
    var code = "__retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE;\n" + //Change return value to TURN_COUNTERCLOCKWISE
      "propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" + //Save variable to map before returning
      "return __retVal;\n"; //return to Java
    return code;
};

Blockly.JavaScript['maze_look'] = function(block) {
  var value_playerdirection = Blockly.JavaScript.valueToCode(block, 'playerDirection', Blockly.JavaScript.ORDER_ATOMIC);
  // TODO: Assemble JavaScript into code variable.
  var code = 'instance.look(' + value_playerdirection + ")";
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_canmove_left'] = function(block) {
  var code = 'instance.canMoveLeft()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_canmove_right'] = function(block) {
    var code = 'instance.canMoveRight()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_canmove_forward'] = function(block) {
    var code = 'instance.canMoveForward()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_canmove_backward'] = function(block) {
    var code = 'instance.canMoveBackward()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_direction_north'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.Direction.NORTH';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_direction_south'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.Direction.SOUTH';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_direction_east'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.Direction.EAST';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_direction_west'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.Direction.WEST';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_init_function'] = function(block) {
  var statements_init = Blockly.JavaScript.statementToCode(block, 'init');
  var code = "function init(instance) {\n" +
   //Detect the declared variables:
   "  populatePropNames();\n" +
   //Run the user's initialization statements:
   statements_init +
   //Save the values into the map:
   "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
   "}/*end init()*/\n\n";
  return code;
};

Blockly.JavaScript['maze_run_function'] = function(block) {
  var statements_run = Blockly.JavaScript.statementToCode(block, 'run');
  var code = "function run(instance) {\n" +
  //Detect the declared variables:
  "  populatePropNames();\n" +
  //Default return value:
  "  var __retVal = Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.NO_MOVE;\n" +
  //Get the values of the variables from the map:
  "  propNames.forEach(function(item, index) {\n" +
  "      var mapValue = instance.getJavascriptArgument(item);\n" +
  //Check if this is a boolean literal
  "      if (mapValue == 'false') this[item] = false;\n" +
  "      else if (mapValue == 'true') this[item] = true;\n" +
  //Check if this is a number literal
  "      else if (!isNaN(mapValue)) this[item] = Number(mapValue); \n" +
  //Check if this is a direction literal
  "      else if (mapValue == 'north') this[item] = Packages.org.inspirecenter.amazechallenge.model.Direction.NORTH;\n" +
  "      else if (mapValue == 'south') this[item] = Packages.org.inspirecenter.amazechallenge.model.Direction.SOUTH;\n" +
  "      else if (mapValue == 'west') this[item] = Packages.org.inspirecenter.amazechallenge.model.Direction.WEST;\n" +
  "      else if (mapValue == 'east') this[item] = Packages.org.inspirecenter.amazechallenge.model.Direction.EAST;\n" +
  //Otherwise it's a string/character literal
  "  });\n" +
  //Include the player's code:
  "\n\n/*---- PLAYER'S CODE ----*/\n\n" + statements_run + "\n\n/*---------------------*/\n\n" +
  //Save all of the values back to the map:
  "  propNames.forEach(function(item, index) { instance.setJavascriptArgument(item, this[item]); } );\n" +
  //If the code does not return yet, return the default value (NO_MOVE).
  "  return __retVal;\n" +

  "}/*end run()*/\n";
  return code;
};

Blockly.JavaScript['maze_randomint'] = function(block) {
  var value_min = Blockly.JavaScript.valueToCode(block, 'min', Blockly.JavaScript.ORDER_ATOMIC);
  var value_max = Blockly.JavaScript.valueToCode(block, 'max', Blockly.JavaScript.ORDER_ATOMIC);
  var code = "_getRandomInt(" + value_min + ", " + value_max + ")";
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_pickabletype_reward'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.PickableType.Bias.REWARD';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_pickabletype_penalty'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.PickableType.Bias.PENALTY';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_pickabletype_none'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.model.PickableType.Bias.NONE';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_get_direction'] = function(block) {
  var code = 'instance.getDirection()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_compass'] = function(block) {
  var code = 'instance.compass()';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_onmove'] = function(block) {
  var value_move = Blockly.JavaScript.valueToCode(block, 'move', Blockly.JavaScript.ORDER_ATOMIC);
  var code = 'instance.onMove(' + value_move + ')';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_literal_move_forward'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.MOVE_FORWARD';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_literal_turn_clockwise'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_CLOCKWISE';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_literal_turn_counterclockwise'] = function(block) {
  var code = 'Packages.org.inspirecenter.amazechallenge.algorithms.PlayerMove.TURN_COUNTERCLOCKWISE';
  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['maze_math_compare'] = function(block) {
  var value_number1 = Blockly.JavaScript.valueToCode(block, 'number1', Blockly.JavaScript.ORDER_ATOMIC);
  var dropdown_operator = block.getFieldValue('operator');
  var value_number2 = Blockly.JavaScript.valueToCode(block, 'number2', Blockly.JavaScript.ORDER_ATOMIC);

  var code = '';

  if (dropdown_operator == "more") {
      code = "(" + value_number1 + " > " + value_number2 + ")";
  }
  else if (dropdown_operator == "more_equal") {
       code = "(" + value_number1 + " >= " + value_number2 + ")";
  }
  else if (dropdown_operator == "less") {
       code = "(" + value_number1 + " < " + value_number2 + ")";
  }
  else if (dropdown_operator == "less_equal") {
       code = "(" + value_number1 + " <= " + value_number2 + ")";
  }

  return [code, Blockly.JavaScript.ORDER_NONE];
};