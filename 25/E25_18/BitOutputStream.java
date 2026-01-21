import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;

public class BitOutputStream implements AutoCloseable {
  private ObjectOutputStream output;
  private int bits;
  private int position;

  public BitOutputStream(File file) throws IOException {
    // wrapped in an ObjectOutputStream so we can write to the targetfile
    // using that object exclusively in order to avoid stream corruption
    output = new ObjectOutputStream(new FileOutputStream(file));
  }

  public void writeObject(Object object) throws IOException {
    // wrap ObjectOutputStream's writeObject method
    output.writeObject(object);
  }

  public void writeInt(int n) throws IOException {
    // wrap ObjectOuputStream's writeInt method
    output.writeInt(n);
  }

  public void writeBit(char bit) throws IOException {
    bits = bits << 1;
    if (bit == '1') {
      bits = bits | 1;
    }

    position++;

    if (position == 8) {
      output.write((byte)bits);
      bits = 0;
      position = 0;
    }
  }

  public void writeBit(String bit) throws IOException {
    for (int i = 0; i < bit.length(); i++) {
      char c = bit.charAt(i);
      writeBit(c);
    }
  }

  public void close() throws IOException {
    if (bits != 0) {
      bits = bits << (8 - position);
      output.write((byte)bits);
    }
    output.close();
  }
}
