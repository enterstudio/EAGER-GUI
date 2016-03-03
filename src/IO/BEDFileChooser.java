/*
 * Copyright (c) 2016. eager-gui Alexander Peltzer
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package IO;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 20.08.13
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class BEDFileChooser {
    private JFileChooser jfc = new JFileChooser();
    private FileFilter ff;


    public BEDFileChooser(Communicator c){
        if(c.getGUI_filepathinput() != null){
            jfc.setCurrentDirectory(new File(c.getGUI_filepathinput()));
        }
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        ff = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return  file.isDirectory() || file.getName().toLowerCase().endsWith(".bed");
            }

            @Override
            public String getDescription() {
                return "only *.bed Files supported";  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        jfc.setFileFilter(ff);
        int state = jfc.showOpenDialog(null);
        if (state == JFileChooser.FILES_ONLY){
            File[] f = jfc.getSelectedFiles();
            c.setBedfile(f[0].getAbsolutePath());
        }
    }

}
