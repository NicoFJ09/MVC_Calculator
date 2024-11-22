package com.mycompany.mvccalculator.Data;

import com.mycompany.mvccalculator.View.Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BitacoraManager {
    private Data _data;
    private final String filePath;

    public BitacoraManager(Data _data, String filePath) {
        this._data = _data;
        this.filePath = filePath;
    }

    public void escribirEnBitacora(String mensaje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en la bitácora: " + e.getMessage());
        }
    }

    public void actualizarBitacora() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            _data.txt_area.setText("");

            String linea;
            while ((linea = reader.readLine()) != null) {
                _data.txt_area.append(linea + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de bitácora: " + e.getMessage());
        }
    }
}
