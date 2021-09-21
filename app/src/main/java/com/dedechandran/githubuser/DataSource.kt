package com.dedechandran.githubuser

object DataSource {
    fun generateFakeData(size: Int): List<GithubUser>{
        val data = mutableListOf<GithubUser>()
        for(i in 1..size){
            data.add(
                GithubUser(
                    name = "Github User $i",
                    location = "Location $i",
                    image = R.drawable.ic_launcher_background
                )
            )
        }
        return data
    }
}