/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package com.nkasenides.amc.model;

import com.nkasenides.athlos.proto.Transmittable;
import com.nkasenides.amc.proto.*;
import com.nkasenides.athlos.model.*;

public class QuestionEntry implements Transmittable<QuestionEntryProto.Builder> {
    private String answerText;    
    private String questionText;    

    public String getAnswerText() {    
        return answerText;        
    }    
    
    public String getQuestionText() {    
        return questionText;        
    }    
    

    public void setAnswerText(String answerText) {    
        this.answerText = answerText;        
    }    
    
    public void setQuestionText(String questionText) {    
        this.questionText = questionText;        
    }    
    

    @Override    
    public com.nkasenides.amc.proto.QuestionEntryProto.Builder toProto() {    
        com.nkasenides.amc.proto.QuestionEntryProto.Builder protoBuilder = com.nkasenides.amc.proto.QuestionEntryProto.newBuilder();        
        protoBuilder.setAnswerText(answerText);        
        protoBuilder.setQuestionText(questionText);        
        return protoBuilder;        
    }    
    

}
