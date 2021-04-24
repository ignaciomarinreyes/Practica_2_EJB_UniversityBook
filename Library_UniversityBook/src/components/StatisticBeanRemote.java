/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface StatisticBeanRemote {

    int getNumberUserHasLogged();

    void increaseNumberUserHasLogged();

    int getNumberUserLoggedNow();
    
}
