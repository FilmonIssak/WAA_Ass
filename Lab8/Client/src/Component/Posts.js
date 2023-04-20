import Post from "./Post";


const Posts = (props) => {
    return (
        props.data.map((e) => {
            return <Post id={e.id} title={e.title} author={e.author} content={e.content} getPostById={props.getPostById} />
        })
    )
}

export default Posts;