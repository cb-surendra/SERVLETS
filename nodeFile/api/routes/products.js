const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message:'Handling GET requests to /products'
    });
});

router.post('/', (req, res, next) => {
    res.status(200).json({
        message: 'Handlong POST request to /products'
    });
});

router.get('/:productId', (req, res, next) => {
    
    const id = req.params.productId;
    if( id === 'special'){
        res.status(200).json({
            message: 'You got the product'
        });
    } else {
        res.status(200).json({
            message: 'Simple Id passed'
        });
    }
});
router.patch('/:productId', (req, res, next) => {
   res.status(200).json({
       message: 'Product Updated'
   })
});

router.delete('/:productId', (req, res, next) => {
    res.status(200).json({
        message: 'Product Deleted'
    })
 });
 
module.exports = router;