// Standard calls that all Sensors will call repeatedly during application.
public interface Interface_Sensor {

	public String startSimulation(); // Called at beginning
	public String endSimulation(int simulationID); // Called at end
	public String getSimulationData(int simulationID); // Called repeatedly while still running application.

}