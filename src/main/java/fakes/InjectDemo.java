package fakes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

interface CanLog {
  void log(String message);
}

class FileLogger implements CanLog {
  @Override
  public void log(String message) {
    try {
      Files.write(Paths.get("src/main/resources/log.txt"), message.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

class ConsoleLogger implements CanLog {
  @Override
  public void log(String message) {
    System.out.println("LOG: " + message);
  }
}

class Logger {
  private final CanLog canLog;

  public Logger(CanLog canLog) {
    this.canLog = canLog;
  }

  public void doLog(String message) {
    canLog.log(message);
  }
}

public class InjectDemo {

  public static void main(String[] args) {
    final Logger logger = new Logger(new FileLogger());
    logger.doLog("test log 1");

    final Logger logger2 = new Logger(new ConsoleLogger());
    logger2.doLog("test log 2");
  }
}
