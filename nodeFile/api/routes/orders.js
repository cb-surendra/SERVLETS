const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message:'Handling GET requests to /orders'
    });
});

router.post('/', (req, res, next) => {
    res.status(200).json({
        message: 'Handlong POST request to /orders'
    });
});

router.get('/:orderId', (req, res, next) => {

    res.status(200).json({
        message: 'Order details',
        orderId: req.params.orderId
    });
});
router.delete('/:orderId', (req, res, next) => {
    res.status(200).json({
        message: 'Order Deleted',
        orderId: req.params.orderId
    });
 });
 
module.exports = router;