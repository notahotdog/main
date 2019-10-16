package Commands;

import Farmio.Farmio;
import FarmioExceptions.FarmioException;

public class CommandStart extends Command {
    @Override
    public void execute(Farmio farmio) throws FarmioException {
        System.out.println("STARTING DAY");
        farmio.setStage(Farmio.Stage.RUNNING_DAY);
    }
}
