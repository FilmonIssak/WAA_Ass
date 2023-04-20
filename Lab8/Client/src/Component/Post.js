import React from 'react'

export default function Post({ id, title, author, content, getPostById }) {

    return (

        <button onClick={() => getPostById(id)} style={{ width: "200px" }} key={id}>
            <div style={{ margin: "10%", fontSize: '8px' }}>
                <h1>{id}</h1>
                <h1>{title}</h1>
                <h1>{author}</h1>
                <h1>{content}</h1>
            </div>
        </button>
    )
}
