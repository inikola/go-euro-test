package org.goeuro.test.common.model;

import java.util.Arrays;

/**
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class InputValidator {


    private InputValidator(){
        //no instantiation allowed
    }


    public static void validateInput(String [] args){
        if(args.length < 1){
            throw new IllegalArgumentException("Query must be specified");
        }

    }
}
