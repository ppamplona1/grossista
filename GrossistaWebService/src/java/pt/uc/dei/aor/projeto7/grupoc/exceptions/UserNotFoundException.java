/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.exceptions;

/**
 *
 * @author User
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("user not found");
    }

}
