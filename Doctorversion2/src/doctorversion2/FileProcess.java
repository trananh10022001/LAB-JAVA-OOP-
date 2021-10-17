/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorversion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ThinkPro
 */
public class FileProcess {

    //Lấy ra List Doctor từ file
    public static List<Doctor> getAllDoctor() {
        FileInputStream fi = null;
        try {
            File file = new File("db.txt");
            if (!file.exists()) {//Nếu file không tồn tại thì tạo file mới với tên DB và add List Trống vào file
                saveAllDoctor(new ArrayList<>());
            }
            fi = new FileInputStream(new File("db.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            List<Doctor> list = (List<Doctor>) oi.readObject();
            if (list == null) { // Nếu list null thì tạo List Trống và lưu vào file
                list = new ArrayList<>();
                saveAllDoctor(new ArrayList<>());
            }
            return list;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //Ghi List Doctor vào file
    public static void saveAllDoctor(List<Doctor> listDoctor) {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(new File("db.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            // Write objects to file
            o.writeObject(listDoctor);
            o.close();
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
