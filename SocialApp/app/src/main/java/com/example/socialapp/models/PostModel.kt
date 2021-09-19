import com.example.socialapp.models.User

data class PostModel(
        val text : String = "",
        val createdBy : User = User(),
        val createdAt : Long = 0,
        val likedBy : ArrayList<Integer> = ArrayList()
)