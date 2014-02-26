/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 *
 * @author Aditsan Kadmus
 */
public class FontsPartieRestaurateur {
    private Font fTitle, fLbl, fBtn;
    public static final int TITLE=0, LABEL=1, BUTTON=2;
    
    public Font getFont(int fontcode) throws FontFormatException, IOException
    {
        switch (fontcode)
        {
            case TITLE:
                Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/track.ttf"));
            case LABEL:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/onramp.ttf"));
            case BUTTON:
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/esprit/rt/fonts/franchise_bold.ttf"));
        }       
        return null;
    }
    
}
