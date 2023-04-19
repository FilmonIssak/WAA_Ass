import React, { useState } from 'react'
import Posts from '../Component/Posts';
import PostDetail from './PostDetail';


export default function Dashboard() {

    const [postsState, setPostsState] = useState(
        [
            { id: 1, title: "happy", author: "fili" },
            { id: 2, title: "family", author: "mg" },
            { id: 3, title: "horror", author: "dani" }
        ]
    );

    const [title, setTitle] = useState('');
    const [postDetail, setPostDetail] = useState({})


    const handleInput = () => {
        const copy = [...postsState];
        copy[0].title = title
        setPostsState(copy)
    }

    const handleToggle = (id) => {
        const findIndex = postsState.findIndex(data => data.id === id)
        const post = postsState[findIndex]
        setPostDetail(post)
    }

    const handleEdit = () => {
        console.log('edit')
    }
    const handleDelete = () => {
        console.log('delete')
    }

    return (
        <div >
            <div style={{ display: "inline-flex" }}>
                <Posts data={postsState} handleToggle={handleToggle} />
            </div>
            <br>
            </br>
            <div>
                <input onChange={(event) => setTitle(event.target.value)} type='text' />
                <button onClick={handleInput}>Change name</button>
            </div>
            

            <div>
                <PostDetail data={postDetail} handleEdit={handleEdit} handleDelete={handleDelete} />
            </div>

        </div>
    )
}

