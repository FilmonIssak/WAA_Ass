import Post from "./Post";


const Posts = (props) => {
    console.log(props)
    return (
        props.data.map((e) => {
            return <Post id={e.id} title={e.title} author={e.author} handleToggle={props.handleToggle} />
        })
    )
}

export default Posts;