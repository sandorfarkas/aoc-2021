class Day12(private val input: List<String> = readInput("day12-input-test.txt")) {
	private val connections = input.map{ createEdge(it) }
	val starts = connections.filter { it.node1.name == "start" || it.node2.name == "start" }
	val ends = connections.filter { it.node2.name == "end" || it.node2.name == "end" }

	private fun createEdge(it: String): Edge {
		val parts = it.split("-");
		return Edge(Node(parts[0]), Node(parts[1]))
	}

	fun first(): Int {
		val paths = mutableListOf<List<Edge>>()

		return -1
	}
}

class Node(val name: String) {
	fun isBigCave() = name[0].isUpperCase()
}

class Edge(val node1: Node, val node2: Node) {

}
