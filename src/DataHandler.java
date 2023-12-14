package src;

import java.io.File;
import java.io.FileWriter;

public class DataHandler {
    private String fileName;
    private StringBuilder stringInFile;

    private int quantityInfo = 6;

    private String[] dataArr;

    public DataHandler(String data) throws Exception {
        this.stringInFile = new StringBuilder();
        this.dataArr = data.split(" ");
        
        if(this.checkQuantityInfo() == -1) {
            throw new Exception("Вы ввели меньше данных, чем требовалось!");
        } else if(this.checkQuantityInfo() == -2) {
            throw new Exception("Вы ввели больше данных, чем требовалось!");
        }

        for (String item : dataArr) {
            this.validateInfo(item);
        }

        this.createFile();
    }

    private int checkQuantityInfo() {
        if(dataArr.length < this.quantityInfo) {
            return -1;
        } else if(dataArr.length > this.quantityInfo) {
            return -2;
        }

        return 1;
    }

    private void validateInfo(String param) {
        try {
            // Здесь должна быть проверка на номер телефона
            Long.parseLong(param);
            this.stringInFile.append(param);
        } catch (Exception e) {
            this.stringValidate(param);
        }
    }

    private void stringValidate(String param) {
        if(this.fileName == null && param.length() > 1) {
            this.fileName = param;
        }

        this.stringInFile.append(param);
    }
    
    private void createFile() throws Exception {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);

        if(!file.exists()) {
            file.createNewFile();
        }

        fw.append(this.stringInFile);
        fw.close();
    }
}
