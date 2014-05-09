/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.gupoc.techoapoclient.settings;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named
@SessionScoped
public class Settings implements Serializable {

    private boolean isSoap;

    private APIClient apiClient;

    /**
     * Creates a new instance of Settings
     */
    public Settings() {
    }

    public boolean isIsSoap() {
        return isSoap;
    }

    public void setIsSoap(boolean isSoap) {
        this.isSoap = isSoap;
    }

    public APIClient getApiClient() {
        if (isSoap) {
            return new SoapClient();
        } else {
            return new RestClient();
        }

    }

    public void setApiClient(APIClient apiClient) {
        this.apiClient = apiClient;
    }

}
