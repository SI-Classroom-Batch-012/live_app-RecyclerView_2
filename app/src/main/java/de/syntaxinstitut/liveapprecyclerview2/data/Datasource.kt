package de.syntaxinstitut.liveapprecyclerview2.data

class Datasource {

    fun loadTeams() : MutableList<Team> {

        val result = mutableListOf<Team>()

        for (i in 1..20){
            val newTeam = Team("Team $i", 0)
            result.add(newTeam)
        }

        return result

    }

}