import React from 'react'


export default function PostDetail(props) {
    const style = {
        border: "2px solid black",
        margin: "30px"
    }


    return (
        <div style={style}>
            {console.log(props)}
            <h1>{props.data.title}</h1>
            <h2>{props.data.author}</h2>
            <p>This is the content in the post...</p>

            <button onClick={props.handleEdit}>edit</button>
            <button onClick={props.handleDelete}>delete</button>
        </div>
    )
}
