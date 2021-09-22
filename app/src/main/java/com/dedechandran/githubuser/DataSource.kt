package com.dedechandran.githubuser

object DataSource {
    private val data =  mutableListOf<GithubUser>()

    fun generateFakeData(size: Int): List<GithubUser>{
        for(i in 1..size){
            data.add(
                GithubUser(
                    name = "Github User $i",
                    location = "Location $i",
                    image = R.drawable.ic_launcher_background,
                    id = i
                )
            )
        }
        return data
    }

    fun getDetails(id: String): GithubUser?{
        return data.find { it.id.toString() == id }
    }
}