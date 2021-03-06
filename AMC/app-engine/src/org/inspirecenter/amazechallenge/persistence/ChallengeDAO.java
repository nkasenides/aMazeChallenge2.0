/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Framework: http://nkasenides.github.io/athlos
  Generated on: 12-08-2021 11:56:05
  Athlos Project Editor, v0.1.0 BETA
-------------------------------------------------------------------------------- */

package org.inspirecenter.amazechallenge.persistence;


import com.nkasenides.athlos.persistence.*;
import org.inspirecenter.amazechallenge.model.*;
import com.raylabz.firestorm.Firestorm;
import com.raylabz.firestorm.FirestormBatch;
import org.inspirecenter.amazechallenge.model.Challenge;

import java.util.Collection;


public class ChallengeDAO implements MultiDAO<Challenge> {


    @Override
    public boolean create(Challenge object) {
        return Firestorm.create(object) != null;
    }

    @Override
    public boolean update(Challenge object) {
        Firestorm.update(object);
        return true;
    }

    @Override
    public boolean delete(Challenge object) {
        Firestorm.delete(object);
        return true;
    }

    @Override
    public Challenge get(String id) {
        return Firestorm.get(Challenge.class, id);
    }

    @Override
    public Collection<Challenge> getMany(String... ids) {
        return Firestorm.getMany(Challenge.class, ids);
    }

    @Override
    public Collection<Challenge> list() {
        return Firestorm.listAll(Challenge.class);
    }

    @Override
    public boolean create(Collection<Challenge> objects) {
        Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (Challenge object : objects) {
                    create(object);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        });
        return true;
    }

    @Override
    public boolean update(Collection<Challenge> objects) {
        Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (Challenge object : objects) {
                    update(object);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        });
        return true;
    }

    @Override
    public boolean delete(Collection<Challenge> objects) {
        Firestorm.runBatch(new FirestormBatch() {
            @Override
            public void execute() {
                for (Challenge object : objects) {
                    delete(object);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onSuccess() {

            }
        });
        return true;
    }


}


