/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import java.io.InputStream;
/**
 *
 * @author jcsv
 */
public interface IVideo {
    int getNumber();
    String getTitle();
    InputStream getDataAsStream();
}
