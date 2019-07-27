from numpy import exp, array, random, dot

class NeuralNetwork():
    def __init__(self):
        random.seed(42)
        self.weights = 2 * random.random((4, 1)) - 1

    def __sigmoid(self, x):
        return 1 / (1 + exp(-x))

    def __sigmoid_derivative(self, x):
        return x * (1 - x)        

    def train(self, training_inputs, training_outputs, training_iterations):
        for i in range(len(training_inputs)):
            training_inputs[i, 0] = (training_inputs[i, 0] + 90) /180
            training_inputs[i, 1] = (training_inputs[i, 1] + 180) / 360
            training_inputs[i, 2] = training_inputs[i, 2] / 100
            training_inputs[i, 3] = training_inputs[i, 3] / 10000
        for iteration in range(training_iterations):
            output = self.think(training_inputs)
            error = training_outputs - output
            adjustment = dot(training_inputs.T, error * self.__sigmoid_derivative(output))
            self.weights += adjustment

    def think(self, inputs):
        return self.__sigmoid(dot(inputs, self.weights))

if __name__ == "__main__":

    # Input format
    # 1st field: Latitude of project in degrees (north positive, south negative)
    # 2nd field: Longitude of project in degrees (east positive, west negative)
    # 3rd field: Length of project in months
    # 4th field: Cost of project in dollars

    # Output format
    # 1: donation
    # 0: no donation, interest

    # Marcus

    marcus_inputs = array([[35.0, 105.0, 4, 1000], [35.0, 105.0, 6, 500], [37.0, -95.0, 2, 2000], [37.0, -95.0, 100, 5000], [61.0, 101.0, 120, 6000], [6.0, -66.0, 89, 1000], [6.0, -66.0, 50, 1000], [6.0, -66.0, 2, 1000], [32.0, 53.0, 100, 1000], [32.0, 53.0, 89, 21311]])
    marcus_outputs = array([[1, 1, 1, 1, 0, 0, 1, 0, 0, 0]]).T

    print("Marcus")
    marcus_network = NeuralNetwork()

    print("Starting weights: ")
    print(marcus_network.weights)

    marcus_network.train(marcus_inputs, marcus_outputs, 10000)
    print("New weights: ")
    print(marcus_network.weights)

    print("Considering [35, 10, 2, 600]: ")
    print(int(marcus_network.think(array([35, 10, 2, 600]))))
    print("Considering [37, -95, 10, 2000]: ")
    print(int(marcus_network.think(array([37, -95, 10, 2000]))))
    print("Considering [61, 101, 200, 6000]: ")
    print(int(marcus_network.think(array([61, 101, 200, 6000]))))

    # Eric

    eric_inputs = array([[7.0, 80.0, 41, 100], [7.0, 80.0, 16, 50], [7.0, 80.0, 90, 200], [-30.0, 23.0, 1, 1200], [-30.0, 23.0, 3, 6000], [-30, 136.0, 3, 1000], [7.0, 80.0, 50, 23], [6.0, -66.0, 2, 6432], [7.0, 80.0, 100, 242], [32.0, 53.0, 89, 2131]])
    eric_outputs = array([[1, 1, 1, 1, 1, 0, 1, 0, 1, 0]]).T

    print("Eric")
    eric_network = NeuralNetwork()

    print("Starting weights: ")
    print(eric_network.weights)

    eric_network.train(eric_inputs, eric_outputs, 10000)
    print("New weights: ")
    print(eric_network.weights)

    print("Considering [7.0, 80.0, 2, 600]: ")
    print(int(eric_network.think(array([7.0, 80.0, 2, 60]))))
    print("Considering [-27, 121, 200, 6000]: ")
    print(int(eric_network.think(array([-27, 121, 200, 6000]))))
    print("Considering [7.0, 90.0, 12, 2000]: ")
    print(int(eric_network.think(array([7.0, 80.0, 12, 20]))))
